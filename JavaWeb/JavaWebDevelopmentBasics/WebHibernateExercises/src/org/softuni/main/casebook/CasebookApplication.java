package org.softuni.main.casebook;

import org.softuni.main.casebook.handlers.utility.ErrorHandler;
import org.softuni.main.casebook.handlers.utility.ResourceHandler;
import org.softuni.main.casebook.utils.HandlerLoader;
import org.softuni.main.javache.Application;
import org.softuni.main.javache.http.HttpContext;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSession;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CasebookApplication implements Application {
    private HttpSession session;
    private ErrorHandler errorHandler;
    private ResourceHandler resourceHandler;
    private Map<String, Map<String, Function<HttpContext, byte[]>>> routesTable;

    public CasebookApplication() {
        this.initializeRoutes();
        this.errorHandler = new ErrorHandler();
        this.resourceHandler = new ResourceHandler();
    }

    private void initializeRoutes() {
        this.routesTable = new HashMap<>();
        HandlerLoader handlerLoader = new HandlerLoader();

        this.loadActionsForMethod("GET", handlerLoader);
        this.loadActionsForMethod("POST", handlerLoader);
    }

    private void loadActionsForMethod(String method, HandlerLoader handlerLoader) {
        Map<String, Method> actions = handlerLoader.getActionsMap(method);

        for (Map.Entry<String, Method> entry : actions.entrySet()) {
            try {
                Object handlerObject = entry.getValue()
                        .getDeclaringClass()
                        .getConstructor()
                        .newInstance();

                this.routesTable.putIfAbsent(entry.getKey(), new HashMap<>());

                this.routesTable.get(entry.getKey()).put(method, (HttpContext httpContext) -> {
                    if (!httpContext.getHttpRequest().getMethod().equals(method)) {
                        return this.errorHandler.badRequest(httpContext).getBytes();
                    }

                    try {
                        return ((HttpResponse) entry.getValue()
                                .invoke(handlerObject, httpContext.getHttpRequest(), httpContext.getHttpResponse()))
                                .getBytes();
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    return null;
                });
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Map<String, Map<String, Function<HttpContext, byte[]>>> getRoutes() {
        return Collections.unmodifiableMap(this.routesTable);
    }

    @Override
    public byte[] handleRequest(HttpContext httpContext) {
        String requestMethod = httpContext.getHttpRequest().getMethod();
        String requestUrl = httpContext.getHttpRequest().getRequestUrl();

        if (this.routesTable.containsKey(requestUrl) && this.getRoutes().get(requestUrl).containsKey(requestMethod)) {
            return this.routesTable.get(requestUrl).get(requestMethod).apply(httpContext);
        } else {
            HttpResponse httpResponse = this.resourceHandler.getResource(httpContext.getHttpRequest(), httpContext.getHttpResponse());

            if (httpResponse == null) {
                return this.errorHandler.notFound(httpContext).getBytes();
            }

            return httpResponse.getBytes();
        }
    }

    @Override
    public HttpSession getSession() {
        return this.session;
    }

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
}