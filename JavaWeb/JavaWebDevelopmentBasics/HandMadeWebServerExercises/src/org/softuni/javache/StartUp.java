package org.softuni.javache;

import org.softuni.javache.lib.handler.RequestHandler;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;

public class StartUp {
    private static final String HANDLERS_FOLDER = "lib";

    private static String rootPath;

    public static void main(String[] args) {
        rootPath = new File(StartUp.class.getProtectionDomain().getCodeSource().getLocation().getPath()).toString();
        start(args);
    }

    private static void start(String[] args) {
        int port = WebConstants.DEFAULT_SERVER_PORT;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        Iterable<RequestHandler> requestHandlers = requestHandlersScan(rootPath + File.separator + HANDLERS_FOLDER, new ArrayList<>());
        Server server = new Server(port, rootPath, requestHandlers);

        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Iterable<RequestHandler> requestHandlersScan(String path, Collection<RequestHandler> requestHandlers) {
        File folderCandidate = new File(path);

        for (File file : folderCandidate.listFiles()) {
            if (file.isDirectory()) {
                requestHandlersScan(file.getPath(), requestHandlers);
            } else {
                if (file.getPath().endsWith(".class")) {
                    String fullPath = file.getPath();
                    String classPath = fullPath
                            .substring(0, fullPath.lastIndexOf('.'))
                            .replace(rootPath + File.separator + HANDLERS_FOLDER + File.separator, "");
                    String className = classPath.replace(File.separatorChar, '.');
                    ClassLoader handlerClassLoader = null;

                    try {
                        handlerClassLoader = new URLClassLoader(
                                new URL[]{
                                        new File(rootPath + File.separator + HANDLERS_FOLDER)
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

                        if (RequestHandler.class.isAssignableFrom(handlerClass)) {
                            RequestHandler handler = (RequestHandler) handlerClass.newInstance();
                            requestHandlers.add(handler);
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return requestHandlers;
    }
}