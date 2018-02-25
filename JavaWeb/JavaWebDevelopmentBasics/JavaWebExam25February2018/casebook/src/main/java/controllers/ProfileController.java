package controllers;

import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.*;
import repositories.UserRepository;

@Controller
public class ProfileController {
    private UserRepository userRepository;

    public ProfileController() {
        this.userRepository = new UserRepository();
    }

    @GetMapping(route = "/profile/{id}")
    @PreAuthorize(loggedIn = true)
    public String profile(@PathVariable String id, HttpSoletRequest request, Model model) {
        String loggedUsername = (String) request.getSession().getAttributes().get("username");
        User loggedUser = this.userRepository.findByUsername(loggedUsername);
        User requestedProfile = this.userRepository.findById(id);

        if (requestedProfile == null) {
            return "redirect:/home";
        }

        if (!id.equals(loggedUser.getId()) && !loggedUser.isFriendWith(requestedProfile.getUsername())) {
            return "redirect:/home";
        }

        model.addAttribute("genderPictureName", requestedProfile.getGender().toLowerCase());
        model.addAttribute("username", requestedProfile.getUsername());
        model.addAttribute("gender", requestedProfile.getGender());

        return "template:profile";
    }
}