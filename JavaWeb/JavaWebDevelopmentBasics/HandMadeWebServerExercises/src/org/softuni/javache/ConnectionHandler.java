package org.softuni.javache;

import org.softuni.javache.io.Reader;
import org.softuni.javache.lib.handler.RequestHandler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ConnectionHandler extends Thread {
    private Socket clientSocket;
    private InputStream clientSocketInputStream;
    private OutputStream clientSocketOutputStream;
    private Map<String, RequestHandler> requestHandlers;
    private Set<String> requestHandlersPriority;
    private String cachedInputStreamContent;

    public ConnectionHandler(Socket clientSocket, Map<String, RequestHandler> requestHandlers, Set<String> requestHandlersPriority) {
        this.initializeConnection(clientSocket);
        this.requestHandlers = requestHandlers;
        this.requestHandlersPriority = requestHandlersPriority;
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
            for (String requestHandlerName : this.requestHandlersPriority) {
                if (!this.requestHandlers.containsKey(requestHandlerName)) {
                    continue;
                }

                RequestHandler requestHandler = this.requestHandlers.get(requestHandlerName);
                requestHandler.handleRequest(this.getClientSocketInputStream(), this.clientSocketOutputStream);

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

    private InputStream getClientSocketInputStream() throws IOException {
        if (this.cachedInputStreamContent == null) {
            this.cachedInputStreamContent = Reader.readAllLines(this.clientSocketInputStream);
        }

        return new ByteArrayInputStream(this.cachedInputStreamContent.getBytes());
    }
}