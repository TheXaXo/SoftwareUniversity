package org.softuni.main.casebook.handlers.utility;

import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ResourceHandler {
    private static final String STATIC_RESOURCES_PATH = System.getProperty("user.dir") + "\\src\\org\\softuni\\main\\casebook\\resources\\public\\";

    public final HttpResponse getResource(HttpRequest httpRequest, HttpResponse httpResponse) {
        try {
            String resourceUrl = httpRequest.getRequestUrl();
            String resourceExtension = resourceUrl.substring(resourceUrl.lastIndexOf(".") + 1);
            byte[] content = Files.readAllBytes(Paths.get(STATIC_RESOURCES_PATH + httpRequest.getRequestUrl()));

            httpResponse.setContent(content);
            httpResponse.setStatusCode(HttpStatus.OK);
            httpResponse.addHeader("Content-Type", this.getContentType(resourceExtension));
            httpResponse.addHeader("Content-Length", Integer.toString(content.length));
            httpResponse.addHeader("Content-Disposition", "inline");

            return httpResponse;
        } catch (IOException e) {
            return null;
        }
    }

    private String getContentType(String resourceExtension) {
        switch (resourceExtension) {
            case "html":
                return "text/html";
            case "css":
                return "text/css";
            default:
                return "text/plain";
        }
    }
}