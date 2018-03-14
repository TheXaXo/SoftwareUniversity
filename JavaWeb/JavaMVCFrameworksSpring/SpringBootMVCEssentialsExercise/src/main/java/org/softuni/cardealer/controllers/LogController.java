package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.log.LogSearchBindingModel;
import org.softuni.cardealer.entities.Log;
import org.softuni.cardealer.services.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LogController {
    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs/all")
    public String allLogs(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        List<Log> logs = this.logService.findAll();

        model.addAttribute("logs", logs);
        return "logs/all";
    }

    @PostMapping("/logs/all/user")
    public String allLogsByUser(LogSearchBindingModel bindingModel, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        List<Log> logs = this.logService.findAllByUser(bindingModel.getUsername());

        model.addAttribute("logs", logs);
        return "logs/all";
    }

    @GetMapping("/logs/clear")
    public String clearAllLogs(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/users/login";
        }

        this.logService.deleteAll();
        return "redirect:/logs/all";
    }
}