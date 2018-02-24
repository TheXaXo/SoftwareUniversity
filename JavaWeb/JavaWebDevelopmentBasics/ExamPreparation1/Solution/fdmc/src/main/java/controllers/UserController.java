package controllers;

import bindingModels.UserLoginBindingModel;
import bindingModels.UserRegisterBindingModel;
import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.*;
import repositories.UserRepository;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    @GetMapping(route = "/login")
    @PreAuthorize
    public String login(HttpSoletRequest request, Model model) {
        model.addAttribute("display", "style=\"display: none\"");

        return "template:login";
    }

    @PostMapping(route = "/login")
    @PreAuthorize
    public String loginConfirm(HttpSoletRequest request, UserLoginBindingModel bindingModel, Model model) {
        User registeredUser = this.userRepository.findByUsername(bindingModel.getUsername());

        if (registeredUser == null || !registeredUser.getPassword().equals(bindingModel.getPassword())) {
            model.addAttribute("display", "style=\"display: block\"");
            model.addAttribute("type", "danger");
            model.addAttribute("message", "User does not exist or password is wrong.");

            return "template:login";
        }

        request.getSession().addAttribute("user-id", registeredUser.getId());
        request.getSession().addAttribute("username", registeredUser.getUsername());
        return "redirect:/";
    }

    @GetMapping(route = "/register")
    @PreAuthorize
    public String register(Model model) {
        model.addAttribute("display", "style=\"display: none\"");

        return "template:register";
    }

    @PostMapping(route = "/register")
    @PreAuthorize
    public String registerConfirm(UserRegisterBindingModel bindingModel, Model model) {
        if (!bindingModel.getPassword().equals(bindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

        if (this.userRepository.findByUsername(bindingModel.getUsername()) != null) {
            model.addAttribute("display", "style=\"display: block\"");
            model.addAttribute("type", "danger");
            model.addAttribute("message", "Username is already taken.");

            return "template:register";
        }

        if (this.userRepository.findByEmail(bindingModel.getEmail()) != null) {
            model.addAttribute("display", "style=\"display: block\"");
            model.addAttribute("type", "danger");
            model.addAttribute("message", "Username with the same email address already exists.");

            return "template:register";
        }

        User user = new User();
        user.setUsername(bindingModel.getUsername());
        user.setPassword(bindingModel.getPassword());
        user.setEmail(bindingModel.getEmail());

        userRepository.createUser(user);
        return "redirect:/login";
    }

    @GetMapping(route = "/logout")
    @PreAuthorize(loggedIn = true)
    public String logout(HttpSoletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}