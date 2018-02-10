package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.handlers.BaseHandler;
import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;
import org.softuni.main.javache.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class BaseDynamicHandler extends BaseHandler {
    private static final String VIEWS_PATH = System.getProperty("user.dir") + "\\src\\org\\softuni\\main\\casebook\\resources\\templates\\";
    private static final String VIEWS_EXTENSION = ".html";

    public BaseDynamicHandler(HttpSessionStorage sessionStorage) {
        super(sessionStorage);
    }

    public String getView(String viewName) {
        try {
            List<String> content = Files.readAllLines(Paths.get(VIEWS_PATH + viewName + VIEWS_EXTENSION));
            return String.join("", content);
        } catch (IOException e) {
            return null;
        }
    }

    public HttpResponse view(String view, HttpRequest request, HttpResponse response) {
        String viewContent = this.getView(view);

        if (viewContent == null) {
            return this.notFound(request, response);
        }

        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", "text/html");
        response.setContent(viewContent.getBytes());

        return response;
    }

    public HttpResponse redirect(String location, HttpRequest request, HttpResponse response) {
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.addHeader("Location", location);

        return response;
    }
}