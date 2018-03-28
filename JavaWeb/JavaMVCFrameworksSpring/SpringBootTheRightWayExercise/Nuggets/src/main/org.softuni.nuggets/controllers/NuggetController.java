package org.softuni.nuggets.controllers;

import org.softuni.nuggets.entities.Nugget;
import org.softuni.nuggets.repositories.NuggetRepository;
import org.softuni.nuggets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/nuggets")
public class NuggetController {
    private final NuggetRepository nuggetRepository;
    private UserRepository userRepository;

    @Autowired
    public NuggetController(NuggetRepository nuggetRepository, UserRepository userRepository) {
        this.nuggetRepository = nuggetRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView) {
        modelAndView.setViewName("nuggets-all");
        modelAndView.addObject("nuggets", this.nuggetRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/mine")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView mine(ModelAndView modelAndView, Principal principal) {
        List<Nugget> preferences = this.userRepository.findByUsername(principal.getName()).getPreferences();

        modelAndView.addObject("preferences", preferences);
        modelAndView.setViewName("user-preferences");

        return modelAndView;
    }
}
