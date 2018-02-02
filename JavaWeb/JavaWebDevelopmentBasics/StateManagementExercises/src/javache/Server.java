package javache;

import javache.http.HttpSession;
import javache.http.HttpSessionImpl;

import java.io.*;
import java.net.*;
import java.util.concurrent.FutureTask;

public class Server {
    private int port;
    private ServerSocket server;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        System.out.println(WebConstants.LISTENING_MESSAGE + this.port);

        this.server.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);
        HttpSession session = new HttpSessionImpl();

        while (true) {
            try (Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler
                        = new ConnectionHandler(clientSocket, new RequestHandler(session));

                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException e) {
                System.out.println(WebConstants.TIMEOUT_DETECTION_MESSAGE);
            }
        }
    }
}