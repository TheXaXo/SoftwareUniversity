package controllers;

import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.*;
import repositories.UserRepository;

@Controller
public class FriendsController {
    private UserRepository userRepository;

    public FriendsController() {
        this.userRepository = new UserRepository();
    }

    @GetMapping(route = "/friends/add/{id}")
    @PreAuthorize(loggedIn = true)
    public String addFriend(@PathVariable String id, HttpSoletRequest request) {
        User loggedUser = this.userRepository.findByUsername((String) request.getSession().getAttributes().get("username"));
        User friendToBeAdded = this.userRepository.findById(id);

        if (friendToBeAdded == null
                || friendToBeAdded.getUsername().equals(loggedUser.getUsername())
                || loggedUser.isFriendWith(friendToBeAdded.getUsername())) {
            return "redirect:/home";
        }

        this.userRepository.addFriend(loggedUser, friendToBeAdded);
        return "redirect:/home";
    }

    @GetMapping(route = "/friends")
    @PreAuthorize(loggedIn = true)
    public String allFriends(HttpSoletRequest request, Model model) {
        StringBuilder result = new StringBuilder();
        User loggedUser = this.userRepository.findByUsername((String) request.getSession().getAttributes().get("username"));

        if (loggedUser.getFriends().isEmpty()) {
            result.append("<p>Get some friends</p>");
        } else {
            for (User friend : loggedUser.getFriends()) {
                result
                        .append("<li class=\"list-group-item\" style=\"border: none; padding-left:0px\">")
                        .append("<div class=\"col-md-6\">")
                        .append(String.format("<b>%s</b>", friend.getUsername()))
                        .append("</div>")
                        .append("<div class=\"col-md-6\">")
                        .append(String.format("<a href=\"/friends/remove/%s\" class=\"btn btn-danger\">Unfriend</a>", friend.getId()))
                        .append("</div>")
                        .append("</li>");
            }
        }

        model.addAttribute("friendsList", result.toString());
        return "template:friends";
    }

    @GetMapping(route = "/friends/remove/{id}")
    @PreAuthorize(loggedIn = true)
    public String removeFriend(@PathVariable String id, HttpSoletRequest request) {
        User loggedUser = this.userRepository.findByUsername((String) request.getSession().getAttributes().get("username"));
        User friendToBeRemoved = this.userRepository.findById(id);

        if (friendToBeRemoved == null
                || loggedUser.getUsername().equals(friendToBeRemoved.getUsername())
                || !loggedUser.isFriendWith(friendToBeRemoved.getUsername())) {
            return "redirect:/home";
        }

        this.userRepository.removeFriend(loggedUser, friendToBeRemoved);
        return "redirect:/friends";
    }
}