package javache;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.FutureTask;

public class Server {
    private final int SOCKET_TIMEOUT_MILLISECONDS = 90;

    private ServerSocket server;
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        this.server.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

        while (true) {
            try (Socket clientSocket = this.server.accept()){
                clientSocket.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket, new RequestHandler());
                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException ex) {
                System.out.println("Connection timed out.");
            }
        }
    }
}
