package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.suppliers.AddSupplierBindingModel;
import org.softuni.cardealer.bindingModels.suppliers.EditSupplierBindingModel;
import org.softuni.cardealer.entities.Log;
import org.softuni.cardealer.entities.Part;
import org.softuni.cardealer.entities.Supplier;
import org.softuni.cardealer.services.LogService;
import org.softuni.cardealer.services.PartService;
import org.softuni.cardealer.services.SupplierService;
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
public class SupplierController {
    private SupplierService supplierService;
    private PartService partService;
    private LogService logService;

    @Autowired
    public SupplierController(SupplierService supplierService, PartService partService, LogService logService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.logService = logService;
    }

    @GetMapping("/suppliers/{supplierType}")
    public String allSuppliersByType(@PathVariable String supplierType, Model model) {
        if (!supplierType.equals("local") && !supplierType.equals("importers")) {
            return "redirect:/";
        }

        List<Supplier> suppliers;

        if (supplierType.equals("local")) {
            suppliers = this.supplierService.findAllLocalSuppliers();
            model.addAttribute("supplierType", "Local Suppliers");
        } else {
            suppliers = this.supplierService.findAllImporterSuppliers();
            model.addAttribute("supplierType", "Importers");
        }

        model.addAttribute("suppliers", suppliers);
        return "suppliers/allByType";
    }

    @GetMapping("/suppliers/all")
    public String allSuppliers(Model model) {
        List<Supplier> suppliers = this.supplierService.findAllSuppliers();

        model.addAttribute("suppliers", suppliers);
        return "suppliers/all";
    }

    @GetMapping("/suppliers/add")
    public String addSupplier(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        return "suppliers/add";
    }

    @PostMapping("/suppliers/add")
    public String addSupplierConfirm(AddSupplierBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Supplier supplier = this.supplierService.findOneByName(bindingModel.getName());

        if (supplier != null) {
            return "redirect:/suppliers/add";
        }

        supplier = new Supplier();
        supplier.setName(bindingModel.getName());
        supplier.setParts(new ArrayList<>());

        if (bindingModel.getType().equals("local")) {
            supplier.setImporter(false);
        } else {
            supplier.setImporter(true);
        }

        this.logService.save(new Log((String) session.getAttribute("username"), "Add", "Supplier", new Date()));
        this.supplierService.save(supplier);
        return "redirect:/suppliers/all";
    }

    @GetMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable long id, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Supplier supplier = this.supplierService.findOneById(id);

        if (supplier == null) {
            return "redirect:/suppliers/add";
        }

        for (Part part : supplier.getParts()) {
            this.partService.delete(part);
        }

        this.logService.save(new Log((String) session.getAttribute("username"), "Delete", "Supplier", new Date()));
        this.supplierService.delete(supplier);
        return "redirect:/suppliers/all";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String editSupplier(@PathVariable long id, HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Supplier supplier = this.supplierService.findOneById(id);

        if (supplier == null) {
            return "redirect:/suppliers/add";
        }

        model.addAttribute("supplier", supplier);
        return "suppliers/edit";
    }

    @PostMapping("/suppliers/edit/{id}")
    public String editSupplierConfirm(@PathVariable long id, HttpSession session, EditSupplierBindingModel bindingModel) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        Supplier supplier = this.supplierService.findOneById(id);

        if (supplier == null) {
            return "redirect:/suppliers/add";
        }

        supplier.setName(bindingModel.getName());

        if (bindingModel.getType().equals("local")) {
            supplier.setImporter(false);
        } else {
            supplier.setImporter(true);
        }

        this.logService.save(new Log((String) session.getAttribute("username"), "Edit", "Supplier", new Date()));
        this.supplierService.update(supplier);
        return "redirect:/suppliers/all";
    }
}