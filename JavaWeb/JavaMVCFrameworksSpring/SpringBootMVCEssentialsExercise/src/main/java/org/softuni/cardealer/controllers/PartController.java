package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.part.AddPartBindingModel;
import org.softuni.cardealer.bindingModels.part.EditPartBindingModel;
import org.softuni.cardealer.entities.Part;
import org.softuni.cardealer.entities.Supplier;
import org.softuni.cardealer.services.PartService;
import org.softuni.cardealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PartController {
    private PartService partService;
    private SupplierService supplierService;

    @Autowired
    public PartController(PartService partService, SupplierService supplierService) {
        this.partService = partService;
        this.supplierService = supplierService;
    }

    @GetMapping("/parts/add")
    public String addPart(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        model.addAttribute("suppliers", supplierService.findAllSuppliers());
        return "parts/add";
    }

    @PostMapping("/parts/add")
    public String addPartConfirm(AddPartBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Part part = new Part();
        Supplier supplier = this.supplierService.findOneByName(bindingModel.getSupplier());

        if (supplier == null) {
            return "redirect:/parts/add";
        }

        part.setName(bindingModel.getName());
        part.setPrice(bindingModel.getPrice());
        part.setQuantity(bindingModel.getQuantity());
        part.setSupplier(supplier);

        partService.create(part);
        return "redirect:/parts/all";
    }

    @GetMapping("/parts/all")
    public String allParts(Model model) {
        List<Part> parts = this.partService.findAll();

        model.addAttribute("parts", parts);
        return "parts/all";
    }

    @GetMapping("/parts/delete/{id}")
    public String deletePart(@PathVariable long id, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Part part = this.partService.findPartById(id);

        if (part == null) {
            return "redirect:/parts/all";
        }

        model.addAttribute("part", part);
        return "parts/delete";
    }

    @PostMapping("/parts/delete/{id}")
    public String deletePartConfirm(@PathVariable long id, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Part part = this.partService.findPartById(id);

        if (part == null) {
            return "redirect:/parts/all";
        }

        this.partService.delete(part);
        return "redirect:/parts/all";
    }

    @GetMapping("/parts/edit/{id}")
    public String editPart(@PathVariable long id, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Part part = this.partService.findPartById(id);

        if (part == null) {
            return "redirect:/parts/all";
        }

        model.addAttribute("part", part);
        return "parts/edit";
    }

    @PostMapping("/parts/edit/{id}")
    public String editPartConfirm(@PathVariable long id, @ModelAttribute EditPartBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Part part = this.partService.findPartById(id);

        if (part == null) {
            return "redirect:/parts/all";
        }

        part.setPrice(bindingModel.getPrice());
        part.setQuantity(bindingModel.getQuantity());

        this.partService.update(part);
        return "redirect:/parts/all";
    }
}