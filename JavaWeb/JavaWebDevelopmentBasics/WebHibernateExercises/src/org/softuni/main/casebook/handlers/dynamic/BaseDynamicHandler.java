package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.handlers.BaseHandler;
import org.softuni.main.casebook.utils.TemplateEngine;
import org.softuni.main.database.models.User;
import org.softuni.main.database.repositories.UserRepository;
import org.softuni.main.javache.WebConstants;
import org.softuni.main.javache.http.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDynamicHandler extends BaseHandler {
    private static final String VIEWS_PATH = System.getProperty("user.dir") + "\\src\\org\\softuni\\main\\casebook\\resources\\templates\\";
    private static final String VIEWS_EXTENSION = ".html";
    private static final String BASE_VIEW_PATH = System.getProperty("user.dir") + "\\src\\org\\softuni\\main\\casebook\\resources\\base-template.html";
    private static final String HEADERS_PATH = System.getProperty("user.dir") + "\\src\\org\\softuni\\main\\casebook\\resources\\headers\\";


    private TemplateEngine templateEngine;
    protected Map<String, String> viewData;

    public BaseDynamicHandler(HttpSessionStorage sessionStorage) {
        super(sessionStorage);
        this.templateEngine = new TemplateEngine();
        this.viewData = new HashMap<>();
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

        String baseViewContent = this.getBaseView();
        String headerContent = this.getHeader(request);

        String renderedContent = this.templateEngine.renderHtml(viewContent, this.viewData);
        baseViewContent = baseViewContent.replace("$(header)", headerContent);
        String fullViewContent = baseViewContent.replace("$(view)", renderedContent);

        if (viewContent == null) {
            return this.notFound(request, response);
        }

        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", "text/html");
        response.setContent(fullViewContent.getBytes());

        return response;
    }

    public HttpResponse redirect(String location, HttpRequest request, HttpResponse response) {
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.addHeader("Location", location);

        return response;
    }

    public User getCurrentUser(HttpRequest request, UserRepository userRepository) {
        HttpCookie cookie = request.getCookies().get(WebConstants.SERVER_SESSION_TOKEN);
        String userId = this.sessionStorage.getSession(cookie.getValue()).getAttributes().get("user-id").toString();

        return  (User) userRepository.doAction("findBy", "id", userId);
    }

    private String getBaseView() {
        try {
            List<String> content = Files.readAllLines(Paths.get(BASE_VIEW_PATH));
            return String.join("", content);
        } catch (IOException e) {
            return null;
        }
    }

    private String getHeaderView(String headerName) {
        try {
            List<String> content = Files.readAllLines(Paths.get(HEADERS_PATH + headerName + VIEWS_EXTENSION));
            return String.join("", content);
        } catch (IOException e) {
            return null;
        }
    }

    private String getHeader(HttpRequest request) {
        if (this.isLoggedIn(request)) {
            return this.getHeaderView("header-user");
        } else {
            return this.getHeaderView("header-guest");
        }
    }
}