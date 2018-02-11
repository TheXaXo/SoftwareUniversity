package org.softuni.javache;

import org.softuni.javache.lib.handler.RequestHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionHandler extends Thread {
    private Socket clientSocket;
    private InputStream clientSocketInputStream;
    private OutputStream clientSocketOutputStream;
    private Iterable<RequestHandler> requestHandlers;
    private String rootPath;

    public ConnectionHandler(Socket clientSocket, String rootPath, Iterable<RequestHandler> requestHandlers) {
        this.initializeConnection(clientSocket);
        this.requestHandlers = requestHandlers;
        this.rootPath = rootPath;
    }

    private void initializeConnection(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            this.clientSocketInputStream = this.clientSocket.getInputStream();
            this.clientSocketOutputStream = this.clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            for (RequestHandler requestHandler : this.requestHandlers) {
                requestHandler.handleRequest(this.clientSocketInputStream, this.clientSocketOutputStream);

                if (requestHandler.hasIntercepted()) {
                    break;
                }
            }

            this.clientSocketInputStream.close();
            this.clientSocketOutputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}