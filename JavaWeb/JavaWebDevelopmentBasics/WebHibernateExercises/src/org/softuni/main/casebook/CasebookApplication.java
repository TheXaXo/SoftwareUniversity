package org.softuni.main.casebook;

import org.softuni.main.casebook.handlers.HomeHandler;
import org.softuni.main.javache.Application;
import org.softuni.main.javache.http.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CasebookApplication implements Application {
    private HttpSession session;
    private HashMap<String, Function<HttpContext, byte[]>> routesTable;

    public CasebookApplication() {
        this.initializeRoutes();
    }

    private void initializeRoutes() {
        this.routesTable = new HashMap<>();

        this.routesTable.put("/", (HttpContext context) -> new HomeHandler().index(context.getHttpRequest(), context.getHttpResponse()).getBytes());
    }

    @Override
    public Map<String, Function<HttpContext, byte[]>> getRoutes() {
        return Collections.unmodifiableMap(this.routesTable);
    }

    @Override
    public byte[] handleRequest(HttpContext httpContext) {
        String requestUrl = httpContext.getHttpRequest().getRequestUrl();

        if (!this.routesTable.containsKey(requestUrl)) {
            return this.notFound(httpContext).getBytes();
        }

        return this.routesTable.get(requestUrl).apply(httpContext);
    }

    @Override
    public HttpSession getSession() {
        return this.session;
    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }

    private HttpResponse notFound(HttpContext httpContext) {
        HttpResponse response = httpContext.getHttpResponse();

        response.addHeader("Content-Type", "text/html");
        response.setStatusCode(HttpStatus.NOT_FOUND);
        response.setContent("<h1>The page is not found</h1>".getBytes());

        return response;
    }
}