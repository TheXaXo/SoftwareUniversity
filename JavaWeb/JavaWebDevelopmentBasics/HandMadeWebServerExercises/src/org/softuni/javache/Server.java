package org.softuni.javache;

import org.softuni.javache.lib.handler.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.FutureTask;

public class Server {
    private static final String LISTENING_MESSAGE = "Listening on port: ";
    private static final String TIMEOUT_DETECTION_MESSAGE = "Timeout detected!";
    private static final Integer SOCKET_TIMEOUT_MILLISECONDS = 5000;

    private int port;
    private int timeouts;
    private ServerSocket server;
    private Iterable<RequestHandler> requestHandlers;
    private String rootPath;

    public Server(int port, String rootPath, Iterable<RequestHandler> requestHandlers) {
        this.port = port;
        this.timeouts = 0;
        this.requestHandlers = requestHandlers;
        this.rootPath = rootPath;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        System.out.println(LISTENING_MESSAGE + this.port);

        this.server.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

        while (true) {
            try (Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler
                        = new ConnectionHandler(clientSocket, this.rootPath, requestHandlers);

                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException e) {
                System.out.println(TIMEOUT_DETECTION_MESSAGE);
                this.timeouts++;
            }
        }
    }
}