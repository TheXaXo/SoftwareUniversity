package org.softuni.main.casebook.handlers;

import org.softuni.main.javache.WebConstants;
import org.softuni.main.javache.http.*;

public abstract class BaseHandler {
    private static final String ERROR_404_MESSAGE = "<h1>The page is not found</h1>";
    private static final String ERROR_400_MESSAGE = "<h1>Malformed request</h1>";

    protected HttpSessionStorage sessionStorage;

    public BaseHandler(HttpSessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public final HttpResponse notFound(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.addHeader("Content-Type", "text/html");
        httpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        httpResponse.setContent(ERROR_404_MESSAGE.getBytes());

        return httpResponse;
    }

    public final HttpResponse badRequest(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.addHeader("Content-Type", "text/html");
        httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        httpResponse.setContent(ERROR_400_MESSAGE.getBytes());

        return httpResponse;
    }

    public final boolean isLoggedIn(HttpRequest request) {
        if (!request.getCookies().containsKey(WebConstants.SERVER_SESSION_TOKEN)) {
            return false;
        }

        HttpCookie cookie = request.getCookies().get(WebConstants.SERVER_SESSION_TOKEN);

        if (this.sessionStorage.getSession(cookie.getValue()) == null) {
            return false;
        }

        return true;
    }
}