package org.softuni.javache.lib.handler;

import org.softuni.javache.WebConstants;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class RequestHandlerLoader {
    private static final String HANDLERS_FOLDER = "lib";
    private static final String HANDLERS_FULL_PATH = WebConstants.SERVER_ROOT_PATH + File.separator + HANDLERS_FOLDER;

    private Map<String, RequestHandler> requestHandlers;

    public RequestHandlerLoader() {
        this.requestHandlers = new LinkedHashMap<>();

        try {
            this.loadRequestHandlers(HANDLERS_FULL_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadRequestHandlers(String path) throws IOException {
        File libDirectory = new File(path);

        if (libDirectory.exists() && libDirectory.isDirectory()) {
            for (File file : libDirectory.listFiles()) {
                if (!this.isLibrary(file)) {
                    continue;
                }

                JarFile library = new JarFile(file.getCanonicalPath());
                this.loadLibrary(library, file.getCanonicalPath());
            }
        }
    }

    public Map<String, RequestHandler> getRequestHandlers() {
        return this.requestHandlers;
    }

    private boolean isLibrary(File file) {
        return file.getName().endsWith(".jar");
    }

    @SuppressWarnings("unchecked")
    private void loadLibrary(JarFile library, String canonicalPath) {
        Enumeration<JarEntry> fileEntries = library.entries();
        try {
            URL[] urls = {new URL("jar:file:" + canonicalPath + "!/")};
            URLClassLoader classLoader = URLClassLoader.newInstance(urls);

            while (fileEntries.hasMoreElements()) {
                JarEntry currentFile = fileEntries.nextElement();

                if (currentFile.isDirectory() || !currentFile.getName().endsWith(".class")) {
                    continue;
                }

                String className = currentFile.getName()
                        .replace(".class", "")
                        .replace("/", ".");

                Class handlerClass = classLoader.loadClass(className);

                if (RequestHandler.class.isAssignableFrom(handlerClass)) {
                    RequestHandler handlerObject = (RequestHandler) handlerClass
                            .getConstructor(String.class)
                            .newInstance(WebConstants.SERVER_ROOT_PATH);

                    this.requestHandlers.putIfAbsent(handlerClass.getSimpleName(), handlerObject);
                }
            }
        } catch (MalformedURLException e) {
            return;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}