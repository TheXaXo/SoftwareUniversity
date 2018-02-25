package controllers;

import bindingModels.UserLoginBindingModel;
import bindingModels.UserRegisterBindingModel;
import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.Controller;
import org.softuni.summer.api.GetMapping;
import org.softuni.summer.api.PostMapping;
import org.softuni.summer.api.PreAuthorize;
import repositories.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Controller
public class UserController {
    private UserRepository userRepository;
    private Set<String> supportedGenders;

    public UserController() {
        this.userRepository = new UserRepository();
        this.supportedGenders = new HashSet<>(Arrays.asList("Male", "Female"));
    }

    @GetMapping(route = "/login")
    @PreAuthorize
    public String login() {
        return "template:login";
    }

    @PostMapping(route = "/login")
    @PreAuthorize
    public String loginConfirm(HttpSoletRequest request, UserLoginBindingModel bindingModel) {
        User registeredUser = this.userRepository.findByUsername(bindingModel.getUsername());

        if (registeredUser == null || !registeredUser.getPassword().equals(bindingModel.getPassword())) {
            return "redirect:/login";
        }

        request.getSession().addAttribute("user-id", registeredUser.getId());
        request.getSession().addAttribute("username", registeredUser.getUsername());

        return "redirect:/home";
    }

    @GetMapping(route = "/register")
    @PreAuthorize
    public String register() {
        return "template:register";
    }

    @PostMapping(route = "/register")
    @PreAuthorize
    public String registerConfirm(UserRegisterBindingModel bindingModel) {
        if (!bindingModel.getPassword().equals(bindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

        if (!this.supportedGenders.contains(bindingModel.getGender())) {
            return "redirect:/register";
        }

        if (this.userRepository.findByUsername(bindingModel.getUsername()) != null) {
            return "redirect:/register";
        }

        User user = new User();
        user.setUsername(bindingModel.getUsername());
        user.setPassword(bindingModel.getPassword());
        user.setFriends(new LinkedHashSet<>());
        user.setGender(bindingModel.getGender());

        this.userRepository.createUser(user);

        return "redirect:/login";
    }

    @GetMapping(route = "/logout")
    @PreAuthorize(loggedIn = true)
    public String logout(HttpSoletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}