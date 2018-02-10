package org.softuni.main.javache.http;

import java.util.Map;

public interface HttpResponse {
    Map<String, String> getHeaders();

    Map<String, HttpCookie> getCookies();

    HttpStatus getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatusCode(HttpStatus statusCode);

    void setContent(byte[] content);

    void addHeader(String header, String value);

    void addCookie(HttpCookie cookie);
}