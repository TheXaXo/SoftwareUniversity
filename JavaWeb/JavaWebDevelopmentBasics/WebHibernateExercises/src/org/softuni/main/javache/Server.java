package org.softuni.main.javache;

import org.softuni.main.javache.http.HttpSessionStorage;
import org.softuni.main.javache.http.HttpSessionStorageImpl;
import org.softuni.main.javache.http.HttpSessionImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.FutureTask;

public class Server {
    private int port;
    private ServerSocket server;
    private Application application;

    public Server(int port, Application application) {
        this.port = port;
        this.application = application;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        this.server.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);

        System.out.println(WebConstants.LISTENING_MESSAGE + this.port);

        HttpSessionStorage sessionStorage = new HttpSessionStorageImpl();
        application.setSessionStorage(sessionStorage);
        application.initializeRoutes();

        while (true) {
            try (Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler
                        = new ConnectionHandler(clientSocket, new RequestHandler(application));

                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException e) {
                System.out.println(WebConstants.TIMEOUT_DETECTION_MESSAGE);
            }
        }
    }
}