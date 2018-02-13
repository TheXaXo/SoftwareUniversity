package org.softuni.javache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ServerConfig {
    private Set<String> orderedHandlersNames;
    private String serverPath;

    public ServerConfig(String serverPath) {
        this.orderedHandlersNames = new LinkedHashSet<>();
        this.serverPath = serverPath;
        this.readHandlersNamesFromConfig();
    }

    private void readHandlersNamesFromConfig() {
        String configFileData = null;

        try {
            configFileData = new String(Files.readAllBytes(Paths.get(serverPath + "/config.ini")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] handlersNames = configFileData.split(": ")[1].split(", ");
        this.orderedHandlersNames.addAll(Arrays.asList(handlersNames));
    }

    public Set<String> getOrderedHandlersNames() {
        return this.orderedHandlersNames;
    }
}