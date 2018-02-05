package org.softuni.main.javache;

import org.softuni.main.javache.http.*;

public class RequestHandler {
    private HttpContext httpContext;
    private Application application;

    public RequestHandler(Application application) {
        this.application = application;
    }

    public byte[] handleRequest(String requestContent) {
        HttpRequest httpRequest = new HttpRequestImpl(requestContent);
        HttpResponse httpResponse = new HttpResponseImpl();

        this.httpContext = new HttpContextImpl(httpRequest, httpResponse);

        return this.application.handleRequest(this.httpContext);
    }
}