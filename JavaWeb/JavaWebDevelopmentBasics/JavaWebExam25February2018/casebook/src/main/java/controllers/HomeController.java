package controllers;

import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.Controller;
import org.softuni.summer.api.GetMapping;
import org.softuni.summer.api.Model;
import org.softuni.summer.api.PreAuthorize;
import repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private UserRepository userRepository;

    public HomeController() {
        this.userRepository = new UserRepository();
    }

    @GetMapping(route = "/")
    @PreAuthorize
    public String index() {
        return "template:index";
    }

    @GetMapping(route = "/home")
    @PreAuthorize(loggedIn = true)
    public String home(HttpSoletRequest request, Model model) {
        List<User> allUsers = this.userRepository.findAll();
        String loggedUsername = (String) request.getSession().getAttributes().get("username");
        User loggedUser = this.userRepository.findByUsername(loggedUsername);

        allUsers = allUsers.stream()
                .filter(u -> !u.getUsername().equals(loggedUsername) && !loggedUser.isFriendWith(u.getUsername()))
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        for (User user : allUsers) {
            result.append(user.toString());
        }

        model.addAttribute("username", loggedUsername);
        model.addAttribute("id", loggedUser.getId());
        model.addAttribute("allUsers", result.toString());
        return "template:home";
    }
}