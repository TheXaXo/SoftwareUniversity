package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.customer.AddCustomerBindingModel;
import org.softuni.cardealer.bindingModels.customer.EditCustomerBindingModel;
import org.softuni.cardealer.entities.Customer;
import org.softuni.cardealer.entities.Sale;
import org.softuni.cardealer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/all/{sortParam}")
    public String allCustomers(@PathVariable String sortParam, Model model) {
        if (!sortParam.equals("ascending") && !sortParam.equals("descending")) {
            return "redirect:/";
        }

        List<Customer> customers;

        if (sortParam.equals("ascending")) {
            customers = this.customerService.findAllCustomersSortedByBirthDateAsc();
            model.addAttribute("sortingType", "Ascending");
        } else {
            customers = this.customerService.findAllCustomersSortedByBirthDateDesc();
            model.addAttribute("sortingType", "Descending");
        }

        model.addAttribute("customers", customers);
        return "customers/all";
    }

    @GetMapping("/customers/{id}")
    public String customerDetails(@PathVariable long id, Model model) {
        Customer customer = this.customerService.findCustomerById(id);

        model.addAttribute("customerName", customer.getName());
        model.addAttribute("boughtCarsCount", customer.getSales().size());
        model.addAttribute("totalSpentOnCars", customer.getSales().stream()
                .mapToDouble(Sale::getSalePrice)
                .sum());

        return "customers/customerDetails";
    }

    @GetMapping("/customers/add")
    public String addCustomer(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        return "customers/add";
    }

    @PostMapping("/customers/add")
    public String addCustomerConfirm(@ModelAttribute AddCustomerBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Customer customer = new Customer();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date birthDate;

        try {
            birthDate = df.parse(bindingModel.getBirthDate());
        } catch (ParseException e) {
            return "redirect:/customers/add";
        }

        customer.setName(bindingModel.getName());
        customer.setBirthDate(birthDate);
        customer.setSales(new ArrayList<>());

        //2 Years of experience based on birth date?!
        customer.setYoungDriver(true);

        this.customerService.create(customer);
        return "redirect:/customers/all/ascending";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable long id, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Customer customer = this.customerService.findCustomerById(id);

        if (customer == null) {
            return "redirect:/customers/all/ascending";
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String dateString = df.format(customer.getBirthDate());

        model.addAttribute("name", customer.getName());
        model.addAttribute("birthDate", dateString);
        model.addAttribute("id", customer.getId());

        return "customers/edit";
    }

    @PostMapping("/customers/edit/{id}")
    public String editCustomerConfirm(@PathVariable long id, @ModelAttribute EditCustomerBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Customer customer = this.customerService.findCustomerById(id);

        if (customer == null) {
            return "redirect:/customers/all/ascending";
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date birthDate;

        try {
            birthDate = df.parse(bindingModel.getBirthDate());
        } catch (ParseException e) {
            return "redirect:/customers/edit/" + customer.getId();
        }

        customer.setName(bindingModel.getName());
        customer.setBirthDate(birthDate);

        this.customerService.update(customer);
        return "redirect:/customers/all/ascending";
    }
}