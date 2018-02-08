package org.softuni.main.casebook.utils;

import org.softuni.main.casebook.annotations.Get;
import org.softuni.main.casebook.annotations.Post;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class HandlerLoader {
    private static final String HANDLERS_DIRECTORY = System.getProperty("user.dir") + "\\src\\org\\softuni\\main\\casebook\\handlers\\dynamic";
    private static final String HANDLERS_PACKAGE = "org.softuni.main.casebook.handlers.dynamic";

    private HashMap<String, HashMap<String, Method>> actionsMap;

    public HandlerLoader() {
        this.actionsMap = new HashMap<>();
        this.initializeSupportedMethods();
        this.loadMaps();
    }

    private void loadMaps() {
        File handlersDirectory = new File(HANDLERS_DIRECTORY);
        List<Class<?>> handlerClasses = new ArrayList<>();

        for (File handlerFile : handlersDirectory.listFiles()) {
            try {
                String handlerClassName = handlerFile.getName().substring(0, handlerFile.getName().indexOf("."));
                Class<?> handlerClass = Class.forName(HANDLERS_PACKAGE + "." + handlerClassName);
                handlerClasses.add(handlerClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (Class<?> handlerClass : handlerClasses) {
            for (Method method : handlerClass.getDeclaredMethods()) {
                method.setAccessible(true);

                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    String annotationName = annotation.annotationType().getSimpleName();

                    if (annotationName.equals("Get")) {
                        this.actionsMap.get("GET").put(((Get) annotation).route(), method);
                    } else if (annotationName.equals("Post")) {
                        this.actionsMap.get("POST").put(((Post) annotation).route(), method);
                    }
                }
            }
        }
    }

    private void initializeSupportedMethods() {
        this.actionsMap.put("GET", new HashMap<>());
        this.actionsMap.put("POST", new HashMap<>());
    }

    public Map<String, Method> getActionsMap(String method) {
        if (!this.actionsMap.containsKey(method)) {
            return null;
        }

        return Collections.unmodifiableMap(this.actionsMap.get(method));
    }
}