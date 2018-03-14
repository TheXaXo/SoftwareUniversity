package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.car.AddCarBindingModel;
import org.softuni.cardealer.entities.Car;
import org.softuni.cardealer.entities.Log;
import org.softuni.cardealer.entities.Part;
import org.softuni.cardealer.services.CarService;
import org.softuni.cardealer.services.LogService;
import org.softuni.cardealer.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {
    private CarService carService;
    private PartService partService;
    private LogService logService;

    @Autowired
    public CarController(CarService carService, PartService partService, LogService logService) {
        this.carService = carService;
        this.partService = partService;
        this.logService = logService;
    }

    @GetMapping("/cars/{make}")
    public String allCarsByMake(@PathVariable String make, Model model) {
        List<Car> cars = this.carService.getAllByMakeOrdered(make);
        model.addAttribute("cars", cars);

        return "cars/all";
    }

    @GetMapping("/cars/all")
    public String allCars(Model model) {
        List<Car> cars = this.carService.findAllCars();
        model.addAttribute("cars", cars);

        return "cars/all";
    }

    @GetMapping("/cars/{id}/parts")
    public String listPartsOfCar(@PathVariable long id, Model model) {
        Car car = this.carService.findCarById(id);
        model.addAttribute("car", car);

        return "cars/listParts";
    }

    @GetMapping("/cars/add")
    public String addCar(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        return "cars/add";
    }

    @PostMapping("/cars/add")
    public String addCarConfirm(AddCarBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Car car = new Car();

        car.setMake(bindingModel.getMake());
        car.setModel(bindingModel.getModel());
        car.setParts(new ArrayList<>());
        car.setTravelledDistance(bindingModel.getTravelledDistance());

        String[] partsId = bindingModel.getPartsId().split(", ");

        for (String partId : partsId) {
            try {
                long id = Long.parseLong(partId);
                Part part = this.partService.findPartById(id);

                if (part == null) {
                    throw new IllegalArgumentException("Part with such id not present.");
                }

                car.getParts().add(part);
            } catch (Exception e) {
                return "redirect:/cars/add";
            }
        }

        this.logService.save(new Log((String) session.getAttribute("username"), "Add", "Car", new Date()));
        this.carService.create(car);
        return "redirect:/cars/all";
    }
}