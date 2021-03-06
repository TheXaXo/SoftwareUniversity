package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.annotations.ApplicationRequestHandler;
import org.softuni.main.casebook.annotations.Get;
import org.softuni.main.casebook.annotations.Post;
import org.softuni.main.database.models.User;
import org.softuni.main.database.repositories.UserRepository;
import org.softuni.main.javache.WebConstants;
import org.softuni.main.javache.http.*;

import java.util.UUID;

@ApplicationRequestHandler
public class UsersHandler extends BaseDynamicHandler {
    public UsersHandler(HttpSessionStorage sessionStorage) {
        super(sessionStorage);
    }

    @Get(route = "/register")
    public HttpResponse register(HttpRequest request, HttpResponse response) {
        return this.view("register", request, response);
    }

    @Post(route = "/register")
    public HttpResponse registerConfirm(HttpRequest request, HttpResponse response) {
        UserRepository userRepository = new UserRepository();

        String username = request.getBodyParameters().get("username");
        String password = request.getBodyParameters().get("password");
        String passwordConfirm = request.getBodyParameters().get("passwordConfirm");

        if (!password.equals(passwordConfirm)) {
            return this.badRequest(request, response);
        }

        if (userRepository.doAction("findBy", "username", username) != null) {
            return this.badRequest(request, response);
        }

        userRepository.doAction("create", username, password);
        userRepository.dismiss();

        return this.redirect("/login", request, response);
    }

    @Get(route = "/login")
    public HttpResponse login(HttpRequest request, HttpResponse response) {
        return this.view("login", request, response);
    }

    @Post(route = "/login")
    public HttpResponse loginConfirm(HttpRequest request, HttpResponse response) {
        UserRepository userRepository = new UserRepository();

        String username = request.getBodyParameters().get("username");
        String password = request.getBodyParameters().get("password");

        User user = (User) userRepository.doAction("findBy", "username", username);

        if (user == null) {
            return this.redirect("/login", request, response);
        } else if (!user.getPassword().equals(password)) {
            return this.redirect("/login", request, response);
        }

        String sessionId = UUID.randomUUID().toString();
        HttpSession session = new HttpSessionImpl(sessionId);

        session.addAttribute("user-id", user.getId());
        this.sessionStorage.setSession(session.getId(), session);

        response.addCookie(new HttpCookieImpl(WebConstants.SERVER_SESSION_TOKEN, session.getId()));

        userRepository.dismiss();
        return this.redirect("/home", request, response);
    }

    @Post(route = "/logout")
    public HttpResponse logout(HttpRequest request, HttpResponse response) {
        if (!this.isLoggedIn(request)) {
            return this.redirect("/login", request, response);
        }

        HttpCookie cookie = request.getCookies().get(WebConstants.SERVER_SESSION_TOKEN);
        this.sessionStorage.removeSession(cookie.getValue());
        response.addCookie(new HttpCookieImpl("Javache", "token=deleted; path=/; expires=Thu, 01 Jan 1970 00:00:00 GMT"));

        return this.redirect("/", request, response);
    }

    @Get(route = "/profile")
    public HttpResponse profile(HttpRequest request, HttpResponse response) {
        if (!this.isLoggedIn(request)) {
            return this.redirect("/login", request, response);
        }

        UserRepository userRepository = new UserRepository();
        User currentUser = this.getCurrentUser(request, userRepository);

        this.viewData.put("username", currentUser.getUsername());

        StringBuilder friendsList = new StringBuilder("<table class=\"table\">");
        friendsList
                .append("<thead>")
                .append("<tr>")
                .append("<th>#</th>")
                .append("<th>Friend Name</th>")
                .append("</tr>")
                .append("</thead>")
                .append("<tbody>");

        int i = 1;

        for (User friend : currentUser.getFriends()) {
            friendsList
                    .append("<tr>")
                    .append("<td>" + i++ + "</td>")
                    .append("<td>" + friend.getUsername() + "</td>")
                    .append("</tr>");
        }

        friendsList
                .append("</tbody>")
                .append("</table>");

        this.viewData.put("friends", friendsList.toString());

        userRepository.dismiss();
        return this.view("profile", request, response);
    }

    @Post(route = "/add-friend")
    public HttpResponse addFriend(HttpRequest request, HttpResponse response) {
        if (!this.isLoggedIn(request)) {
            return this.redirect("/login", request, response);
        }

        UserRepository userRepository = new UserRepository();
        User currentUser = this.getCurrentUser(request, userRepository);

        userRepository.doAction("addFriend", currentUser.getUsername(), request.getBodyParameters().get("friend"));

        userRepository.dismiss();
        return this.redirect("/home", request, response);
    }
}