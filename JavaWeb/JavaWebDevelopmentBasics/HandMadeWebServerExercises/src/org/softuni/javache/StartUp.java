package org.softuni.javache;

import org.softuni.javache.lib.handler.RequestHandler;
import org.softuni.javache.lib.handler.RequestHandlerLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class StartUp {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        int port = WebConstants.DEFAULT_SERVER_PORT;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        Map<String, RequestHandler> requestHandlers = new RequestHandlerLoader().getRequestHandlers();
        Server server = new Server(port, requestHandlers);

        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}