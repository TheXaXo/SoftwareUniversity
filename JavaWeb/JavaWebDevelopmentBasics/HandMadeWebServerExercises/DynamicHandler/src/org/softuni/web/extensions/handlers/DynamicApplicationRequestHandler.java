package org.softuni.web.extensions.handlers;

import org.softuni.javache.http.*;
import org.softuni.javache.io.Reader;
import org.softuni.javache.io.Writer;
import org.softuni.javache.lib.handler.AbstractRequestHandler;
import org.softuni.web.extensions.handlers.lib.Application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

public class DynamicApplicationRequestHandler extends AbstractRequestHandler {
    private static final String APPLICATIONS_FOLDER = "apps";

    private boolean hasIntercepted;
    private Set<Class<? extends Application>> applicationClasses;
    private final HttpSessionStorage sessionStorage;

    public DynamicApplicationRequestHandler(String serverPath) {
        super(serverPath);
        this.applicationClasses = new HashSet<>();
        this.applicationScan(super.serverPath + File.separator + APPLICATIONS_FOLDER);
        this.sessionStorage = new HttpSessionStorageImpl();
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        String requestContent = null;
        int i = 0;

        while (i++ < 5000) {
            try {
                requestContent = Reader.readAllLines(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (requestContent != null && requestContent.length() > 0) {
                this.hasIntercepted = true;
                break;
            }
        }

        byte[] response = null;
        HttpContext context = new HttpContextImpl(new HttpRequestImpl(requestContent), new HttpResponseImpl());

        for (Class<? extends Application> applicationClass : this.applicationClasses) {
            try {
                Application currentApplication = applicationClass.newInstance();
                currentApplication.setSessionStorage(this.sessionStorage);
                currentApplication.initializeRoutes();
                response = currentApplication.handleRequest(context);

                if (response != null) {
                    try {
                        Writer.writeBytes(response, outputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return;
                }

            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        try {
            Writer.writeBytes(new byte[0], outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.hasIntercepted;
    }

    @SuppressWarnings("unchecked")
    private void applicationScan(String path) {
        File folderCandidate = new File(path);

        for (File file : folderCandidate.listFiles()) {
            if (file.isDirectory()) {
                this.applicationScan(file.getPath());
            } else {
                if (file.getPath().endsWith(".class")) {
                    String fullPath = file.getPath();
                    String classPath = fullPath
                            .substring(0, fullPath.lastIndexOf('.'))
                            .replace(super.serverPath + File.separator + APPLICATIONS_FOLDER + File.separator, "");
                    String className = classPath.replace(File.separatorChar, '.');
                    ClassLoader applicationClassLoader = null;

                    try {
                        applicationClassLoader = new URLClassLoader(
                                new URL[]{
                                        new File(super.serverPath + File.separator + APPLICATIONS_FOLDER)
                                                .toURI()
                                                .toURL(),
                                        new File(super.serverPath + File.separator + "handlers")
                                                .toURI()
                                                .toURL()
                                }
                        );
                    } catch (MalformedURLException e) {
                        applicationClassLoader = ClassLoader.getSystemClassLoader();
                        e.printStackTrace();
                    }

                    try {
                        Class applicationClass = applicationClassLoader.loadClass(className);

                        if (Application.class.isAssignableFrom(applicationClass)) {
                            applicationClasses.add(applicationClass);
                        }
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}