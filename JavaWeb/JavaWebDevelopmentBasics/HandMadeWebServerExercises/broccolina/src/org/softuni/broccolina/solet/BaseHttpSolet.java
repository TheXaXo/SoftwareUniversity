package org.softuni.broccolina.solet;

import org.softuni.javache.http.HttpStatus;

public abstract class BaseHttpSolet implements HttpSolet {
    private static final String NOT_FOUND_MESSAGE = "<h1>Error: %s This page or resource is not found.</h1>";

    @Override
    public void doGet(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse) {
        soletResponse.setStatusCode(HttpStatus.NOT_FOUND);
        soletResponse.setContent(String.format(NOT_FOUND_MESSAGE, "GET").getBytes());
        soletResponse.addHeader("Content-Type", "text/html");
    }

    @Override
    public void doPost(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse) {
        soletResponse.setStatusCode(HttpStatus.NOT_FOUND);
        soletResponse.setContent(String.format(NOT_FOUND_MESSAGE, "POST").getBytes());
        soletResponse.addHeader("Content-Type", "text/html");
    }

    @Override
    public void doPut(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse) {
        soletResponse.setStatusCode(HttpStatus.NOT_FOUND);
        soletResponse.setContent(String.format(NOT_FOUND_MESSAGE, "PUT").getBytes());
        soletResponse.addHeader("Content-Type", "text/html");
    }

    @Override
    public void doDelete(HttpSoletRequest soletRequest, HttpSoletResponse soletResponse) {
        soletResponse.setStatusCode(HttpStatus.NOT_FOUND);
        soletResponse.setContent(String.format(NOT_FOUND_MESSAGE, "DELETE").getBytes());
        soletResponse.addHeader("Content-Type", "text/html");
    }
}