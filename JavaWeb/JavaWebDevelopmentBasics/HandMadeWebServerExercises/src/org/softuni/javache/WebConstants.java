package org.softuni.javache;

import java.io.File;

public final class WebConstants {
    public static final Integer DEFAULT_SERVER_PORT = 8000;

    public static final String SERVER_HTTP_VERSION = "HTTP/1.1";

    public static final String SERVER_SESSION_TOKEN = "Javache";

    public static final String SERVER_ROOT_PATH = new File(StartUp.class.getProtectionDomain().getCodeSource().getLocation().getPath()).toString();

    private WebConstants() {
    }
}