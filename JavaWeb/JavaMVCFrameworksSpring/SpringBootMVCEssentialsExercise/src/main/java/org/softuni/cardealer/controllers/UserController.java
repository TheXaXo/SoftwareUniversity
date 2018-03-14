package org.softuni.cardealer.controllers;

import org.softuni.cardealer.bindingModels.user.LoginUserBindingModel;
import org.softuni.cardealer.bindingModels.user.RegisterUserBindingModel;
import org.softuni.cardealer.entities.User;
import org.softuni.cardealer.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/";
        }

        return "users/register";
    }

    @PostMapping("/users/register")
    public String registerConfirm(RegisterUserBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/";
        }

        if (!bindingModel.getPassword().equals(bindingModel.getConfirmPassword())) {
            return "redirect:/users/register";
        }

        if (this.userService.findUserByUsername(bindingModel.getUsername()) != null) {
            return "redirect:/users/register";
        }

        if (this.userService.findUserByEmail(bindingModel.getEmail()) != null) {
            return "redirect:/users/register";
        }

        User user = new User();

        user.setUsername(bindingModel.getUsername());
        user.setEmail(bindingModel.getEmail());
        user.setPassword(bindingModel.getPassword());

        this.userService.register(user);
        return "redirect:/users/login";
    }

    @GetMapping("/users/login")
    public String loginUser(HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/";
        }

        return "users/login";
    }

    @PostMapping("/users/login")
    public String loginUserConfirm(LoginUserBindingModel bindingModel, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/";
        }

        User user = this.userService.findUserByUsername(bindingModel.getUsername());

        if (user == null || !bindingModel.getPassword().equals(user.getPassword())) {
            return "redirect:/users/login";
        }

        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
        return "redirect:/";
    }

    @GetMapping("/users/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        User user = this.userService.findUserById((Long) session.getAttribute("userId"));

        if (user == null) {
            return "redirect:/";
        }

        session.invalidate();
        return "redirect:/";
    }
}