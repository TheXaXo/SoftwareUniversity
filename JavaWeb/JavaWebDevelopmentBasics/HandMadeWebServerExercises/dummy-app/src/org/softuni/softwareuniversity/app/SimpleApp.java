package org.softuni.softwareuniversity.app;

import org.softuni.web.extensions.handlers.lib.Application;

public class SimpleApp implements Application {

    @Override
    public void initializeRoutes() {

    }

    @Override
    public byte[] handleRequest(org.softuni.javache.http.HttpContext httpContext) {
        if (httpContext.getHttpRequest().getRequestUrl().contains("test-app")) {
            return "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<h1>Hello from dummy app!</h1>".getBytes();
        }

        return null;
    }

    @Override
    public org.softuni.javache.http.HttpSessionStorage getSessionStorage() {
        return null;
    }

    @Override
    public void setSessionStorage(org.softuni.javache.http.HttpSessionStorage httpSessionStorage) {

    }
}