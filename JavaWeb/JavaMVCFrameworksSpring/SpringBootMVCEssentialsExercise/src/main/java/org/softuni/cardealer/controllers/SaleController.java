package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.sale.AddSaleBindingModel;
import org.softuni.cardealer.bindingModels.sale.ReviewSaleBindingModel;
import org.softuni.cardealer.entities.Car;
import org.softuni.cardealer.entities.Customer;
import org.softuni.cardealer.entities.Log;
import org.softuni.cardealer.entities.Sale;
import org.softuni.cardealer.services.CarService;
import org.softuni.cardealer.services.CustomerService;
import org.softuni.cardealer.services.LogService;
import org.softuni.cardealer.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class SaleController {
    private SaleService saleService;
    private CustomerService customerService;
    private CarService carService;
    private LogService logService;

    @Autowired
    public SaleController(SaleService saleService, CustomerService customerService, CarService carService, LogService logService) {
        this.saleService = saleService;
        this.customerService = customerService;
        this.carService = carService;
        this.logService = logService;
    }

    @GetMapping("/sales")
    public String allSales(Model model) {
        model.addAttribute("sales", this.saleService.findAllSales());

        return "sales/all";
    }

    @GetMapping("/sales/{id}")
    public String saleDetails(@PathVariable long id, Model model) {
        model.addAttribute("sale", this.saleService.findSaleById(id));

        return "sales/details";
    }

    @GetMapping("/sales/discounted")
    public String allDiscountedSales(Model model) {
        model.addAttribute("sales", this.saleService.findAllDiscountedSales());

        return "sales/all";
    }

    @GetMapping("/sales/discounted/{percentage}")
    public String allDiscountedSalesByPercentage(Model model, @PathVariable double percentage) {
        model.addAttribute("sales", this.saleService.findAllByDiscount(percentage));

        return "sales/all";
    }

    @GetMapping("/sales/add")
    public String addSale(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        model.addAttribute("customers", this.customerService.findAllCustomers());
        model.addAttribute("cars", this.carService.findAllCars());

        return "sales/add";
    }

    @PostMapping("/sales/add")
    public String addSaleConfirm(AddSaleBindingModel bindingModel, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Customer customer = this.customerService.findCustomerById(bindingModel.getCustomerId());
        Car car = this.carService.findCarById(bindingModel.getCarId());

        if (customer == null || car == null) {
            return "redirect:/sales/add";
        }

        model.addAttribute("customerName", customer.getName());
        model.addAttribute("carName", car.getMake() + " " + car.getModel());

        String discountString = bindingModel.getDiscount() + "%";

        if (customer.isYoungDriver()) {
            bindingModel.setDiscount(bindingModel.getDiscount() + 5);

            if (bindingModel.getDiscount() > 100) {
                bindingModel.setDiscount(100);
            }

            discountString = discountString + (" (+5%)");
        }

        double carPrice = car.getAllPartsPrice();
        double finalCarPrice = carPrice - (carPrice * (bindingModel.getDiscount() / 100D));

        model.addAttribute("discountString", discountString);
        model.addAttribute("carPrice", carPrice);
        model.addAttribute("finalCarPrice", finalCarPrice);
        model.addAttribute("discount", bindingModel.getDiscount());
        model.addAttribute("carId", car.getId());
        model.addAttribute("customerId", customer.getId());

        return "sales/review";
    }

    @PostMapping("/sales/review")
    public String reviewSaleConfirm(ReviewSaleBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Customer customer = this.customerService.findCustomerById(bindingModel.getCustomerId());
        Car car = this.carService.findCarById(bindingModel.getCarId());
        Sale sale = new Sale();

        sale.setCustomer(customer);
        sale.setCar(car);
        sale.setDiscount(bindingModel.getDiscount());

        this.logService.save(new Log((String) session.getAttribute("username"), "Add", "Sale", new Date()));
        this.saleService.save(sale);
        return "redirect:/sales";
    }
}