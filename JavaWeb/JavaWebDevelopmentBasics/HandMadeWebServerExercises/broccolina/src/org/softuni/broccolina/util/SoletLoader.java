package org.softuni.broccolina.util;

import org.softuni.broccolina.solet.HttpSolet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SoletLoader {
    private final String APPLICATION_FOLDER_PATH;

    private Map<String, HttpSolet> loadedSolets;

    public SoletLoader(String serverRootPath) {
        this.APPLICATION_FOLDER_PATH = serverRootPath + "\\apps";
        this.loadedSolets = new HashMap<>();

        try {
            this.loadSolets(APPLICATION_FOLDER_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadSolets(String path) throws IOException {
        File appsDirectory = new File(path);

        if (appsDirectory.exists() && appsDirectory.isDirectory()) {
            for (File folder : appsDirectory.listFiles()) {
                for (File file : folder.listFiles()) {
                    if (!this.isLibrary(file)) {
                        continue;
                    }

                    JarFile library = new JarFile(file.getCanonicalPath());
                    this.loadLibrary(library, file.getCanonicalPath());
                }
            }
        }
    }

    public Map<String, HttpSolet> getLoadedSolets() {
        return this.loadedSolets;
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

                Class soletClass = classLoader.loadClass(className);

                if (HttpSolet.class.isAssignableFrom(soletClass)) {
                    HttpSolet soletObject = (HttpSolet) soletClass
                            .getConstructor()
                            .newInstance();

                    this.loadedSolets.putIfAbsent(soletClass.getSimpleName(), soletObject);
                }
            }
        } catch (MalformedURLException e) {
            return;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}