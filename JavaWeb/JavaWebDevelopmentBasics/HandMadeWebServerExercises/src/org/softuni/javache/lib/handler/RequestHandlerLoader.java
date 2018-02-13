package org.softuni.javache.lib.handler;

import org.softuni.javache.StartUp;
import org.softuni.javache.WebConstants;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class RequestHandlerLoader {
    private static final String HANDLERS_FOLDER = "lib";
    private static final String HANDLERS_FULL_PATH = WebConstants.SERVER_ROOT_PATH + File.separator + HANDLERS_FOLDER;

    private Map<String, RequestHandler> requestHandlers;

    public RequestHandlerLoader() {
        this.requestHandlers = new LinkedHashMap<>();
        this.loadRequestHandlers(HANDLERS_FULL_PATH);
    }

    @SuppressWarnings("unchecked")
    public void loadRequestHandlers(String path) {
        File folderCandidate = new File(path);

        for (File file : folderCandidate.listFiles()) {
            if (file.isDirectory()) {
                loadRequestHandlers(file.getPath());
            } else {
                if (file.getPath().endsWith(".class")) {
                    String fullPath = file.getPath();
                    String classPath = fullPath
                            .substring(0, fullPath.lastIndexOf('.'))
                            .replace(HANDLERS_FULL_PATH + File.separator, "");
                    String className = classPath.replace(File.separatorChar, '.');
                    String handlerName = className.substring(className.lastIndexOf(".") + 1);
                    ClassLoader handlerClassLoader = null;

                    try {
                        handlerClassLoader = new URLClassLoader(
                                new URL[]{
                                        new File(HANDLERS_FULL_PATH)
                                                .toURI()
                                                .toURL()
                                }
                        );
                    } catch (MalformedURLException e) {
                        handlerClassLoader = ClassLoader.getSystemClassLoader();
                        e.printStackTrace();
                    }

                    try {
                        Class handlerClass = handlerClassLoader.loadClass(className);

                        if (AbstractRequestHandler.class.isAssignableFrom(handlerClass)) {
                            RequestHandler handler = (RequestHandler) handlerClass
                                    .getDeclaredConstructor(String.class)
                                    .newInstance(WebConstants.SERVER_ROOT_PATH);

                            requestHandlers.put(handlerName, handler);
                        } else if (RequestHandler.class.isAssignableFrom(handlerClass)) {
                            RequestHandler handler = (RequestHandler) handlerClass.newInstance();

                            requestHandlers.put(handlerName, handler);
                        }
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Map<String, RequestHandler> getRequestHandlers() {
        return this.requestHandlers;
    }
}