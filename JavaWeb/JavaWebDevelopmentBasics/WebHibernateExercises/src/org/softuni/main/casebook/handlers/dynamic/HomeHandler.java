package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.annotations.ApplicationRequestHandler;
import org.softuni.main.casebook.annotations.Get;
import org.softuni.main.database.models.User;
import org.softuni.main.database.repositories.UserRepository;
import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationRequestHandler
public class HomeHandler extends BaseDynamicHandler {
    public HomeHandler(HttpSessionStorage sessionStorage) {
        super(sessionStorage);
    }

    @Get(route = "/")
    public HttpResponse index(HttpRequest request, HttpResponse response) {
        return this.view("index", request, response);
    }

    @Get(route = "/home")
    public HttpResponse home(HttpRequest request, HttpResponse response) {
        if (!this.isLoggedIn(request)) {
            return this.redirect("/login", request, response);
        }

        UserRepository userRepository = new UserRepository();

        User[] allUsers = (User[]) userRepository.doAction("findAll");
        StringBuilder listUsers = new StringBuilder("<ul>");

        User currentUser = this.getCurrentUser(request, userRepository);
        List<String> currentUserFriends = currentUser.getFriends().stream()
                .map(User::getUsername)
                .collect(Collectors.toCollection(ArrayList::new));

        for (User user : allUsers) {
            if (user.getUsername().equals(currentUser.getUsername()) || currentUserFriends.contains(user.getUsername())) {
                continue;
            }

            listUsers
                    .append("<li>")
                    .append("<form method=\"post\" action=\"/add-friend\">")
                    .append("<div class=\"form-group\">")
                    .append("<div class=\"row\">")
                    .append("<div class=\"col-2\">")
                    .append("<label class=\"col-form-label\" for=\"friendName\">" + user.getUsername() + "</label>")
                    .append("</div>")
                    .append("<input id=\"friendName\" type=\"hidden\" name=\"friend\" value=\"" + user.getUsername() + "\"</input>")
                    .append("<div class=\"col-10\">")
                    .append("<button class=\"btn btn-sm btn-primary\" type=\"submit\">Add Friend</button>")
                    .append("</div>")
                    .append("</div>")
                    .append("</div>")
                    .append("</form>")
                    .append("</li>");
        }

        listUsers.append("</ul>");
        this.viewData.put("people", listUsers.toString());

        userRepository.dismiss();
        return this.view("home", request, response);
    }
}