package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.annotations.ApplicationRequestHandler;
import org.softuni.main.casebook.annotations.Get;
import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;

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

        return this.view("home", request, response);
    }
}