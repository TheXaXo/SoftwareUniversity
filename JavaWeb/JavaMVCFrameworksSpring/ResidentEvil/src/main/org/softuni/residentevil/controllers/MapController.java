package org.softuni.residentevil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {
    @GetMapping("/map")
    public ModelAndView map(ModelAndView modelAndView) {
        modelAndView.setViewName("map/map");
        return modelAndView;
    }
}