package org.softuni.main.casebook.handlers.utility;

import org.softuni.main.javache.http.HttpContext;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpStatus;

public final class ErrorHandler {
    public final HttpResponse notFound(HttpContext httpContext) {
        HttpResponse response = httpContext.getHttpResponse();

        response.addHeader("Content-Type", "text/html");
        response.setStatusCode(HttpStatus.NOT_FOUND);
        response.setContent("<h1>The page is not found</h1>".getBytes());

        return response;
    }

    public final HttpResponse badRequest(HttpContext httpContext) {
        HttpResponse response = httpContext.getHttpResponse();

        response.addHeader("Content-Type", "text/html");
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.setContent("<h1>Malformed request</h1>".getBytes());

        return response;
    }
}