package org.softuni.residentevil.controllers;

import org.softuni.residentevil.annotations.PreAuthenticate;
import org.softuni.residentevil.entities.User;
import org.softuni.residentevil.models.LoginUserBindingModel;
import org.softuni.residentevil.models.RegisterUserBindingModel;
import org.softuni.residentevil.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView register(ModelAndView modelAndView, @ModelAttribute("user") RegisterUserBindingModel bindingModel) {
        modelAndView.setViewName("user/register");
        return modelAndView;
    }

    @PostMapping("/register")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView registerConfirm(ModelAndView modelAndView, @Valid @ModelAttribute("user") RegisterUserBindingModel bindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/register");

            return modelAndView;
        }

        if (!bindingModel.getPassword().equals(bindingModel.getConfirmPassword())) {
            modelAndView.setViewName("user/register");
            modelAndView.addObject("passwordsDoNotMatch", true);

            return modelAndView;
        }

        if (this.userService.userWithUsernameExists(bindingModel.getUsername())) {
            modelAndView.setViewName("user/register");
            modelAndView.addObject("usernameTaken", true);

            return modelAndView;
        }

        if (this.userService.userWithEmailExists(bindingModel.getEmail())) {
            modelAndView.setViewName("user/register");
            modelAndView.addObject("emailTaken", true);

            return modelAndView;
        }

        this.userService.save(bindingModel);
        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }

    @GetMapping("/login")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView login(ModelAndView modelAndView, @ModelAttribute("user") LoginUserBindingModel bindingModel) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @PostMapping("/login")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView loginConfirm(ModelAndView modelAndView, @Valid @ModelAttribute("user") LoginUserBindingModel bindingModel, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/login");
            return modelAndView;
        }

        User user = this.userService.getUserByUsername(bindingModel.getUsername());

        if (user == null || !user.getPassword().equals(bindingModel.getPassword())) {
            modelAndView.setViewName("user/login");
            modelAndView.addObject("wrongUsernameOrPassword", true);

            return modelAndView;
        }

        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("role", user.getRole());
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

    @GetMapping("/logout")
    @PreAuthenticate(loggedIn = true)
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        session.invalidate();
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
}