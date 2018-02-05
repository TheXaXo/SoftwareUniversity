package org.softuni.main.javache.http;

import java.util.HashMap;

public interface HttpResponse {
    HashMap<String, String> getHeaders();

    HttpStatus getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatusCode(HttpStatus statusCode);

    void setContent(byte[] content);

    void addHeader(String header, String value);

    void addCookie(String cookie, String value);
}