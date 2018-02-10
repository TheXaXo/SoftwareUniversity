package org.softuni.main.javache;

public final class WebConstants {
    public static final Integer DEFAULT_SERVER_PORT = 8000;

    public static final String SERVER_HTTP_VERSION = "HTTP/1.1";

    public static final String LISTENING_MESSAGE = "Listening on port: ";

    public static final String TIMEOUT_DETECTION_MESSAGE = "Timeout detected!";

    public static final Integer SOCKET_TIMEOUT_MILLISECONDS = 50000;

    private static final String SERVER_DIR = System.getProperty("user.dir");

    public static final String ASSETS_FOLDER = SERVER_DIR + "\\src\\resources\\assets";

    public static final String PAGES_FOLDER = SERVER_DIR + "\\src\\resources\\pages";

    public static final String DB_FOLDER = SERVER_DIR + "\\src\\javache\\db";

    public static final String SERVER_SESSION_TOKEN = "Javache";

    private WebConstants() {
    }
}