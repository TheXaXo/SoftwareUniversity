package org.softuni.broccolina;

import org.softuni.broccolina.annotations.WebSolet;
import org.softuni.broccolina.solet.HttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletRequestImpl;
import org.softuni.broccolina.solet.HttpSoletResponseImpl;
import org.softuni.broccolina.util.SoletLoader;
import org.softuni.javache.http.*;
import org.softuni.javache.io.Reader;
import org.softuni.javache.io.Writer;
import org.softuni.javache.lib.handler.AbstractRequestHandler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class SoletDispatcher extends AbstractRequestHandler {
    private boolean hasIntercepted;
    private SoletLoader soletLoader;
    private String cachedInputStreamContent;

    public SoletDispatcher(String serverPath) {
        super(serverPath);
        this.soletLoader = new SoletLoader(serverPath);
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        try {
            HttpSoletRequest soletRequest = new HttpSoletRequestImpl(
                    Reader.readAllLines(this.getInputStream(inputStream)),
                    this.getInputStream(inputStream)
            );

            for (Map.Entry<String, HttpSolet> soletEntry : this.soletLoader.getLoadedSolets().entrySet()) {
                String soletRoute = soletEntry.getValue()
                        .getClass()
                        .getAnnotation(WebSolet.class)
                        .route();

                if (soletRoute.equals(soletRequest.getRequestUrl())) {
                    switch (soletRequest.getMethod()) {
                        case "GET":
                            soletEntry.getValue().doGet(soletRequest, new HttpSoletResponseImpl(outputStream));
                            break;
                        case "POST":
                            soletEntry.getValue().doPost(soletRequest, new HttpSoletResponseImpl(outputStream));
                            break;
                        case "PUT":
                            soletEntry.getValue().doPut(soletRequest, new HttpSoletResponseImpl(outputStream));
                            break;
                        case "DELETE":
                            soletEntry.getValue().doDelete(soletRequest, new HttpSoletResponseImpl(outputStream));
                            break;
                    }
                    this.hasIntercepted = true;
                } else {
                    this.hasIntercepted = false;
                }
            }

            this.cachedInputStreamContent = null;
        } catch (IOException e) {
            this.cachedInputStreamContent = null;
            this.hasIntercepted = false;
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.hasIntercepted;
    }

    private InputStream getInputStream(InputStream inputStream) throws IOException {
        if (this.cachedInputStreamContent == null) {
            this.cachedInputStreamContent = Reader.readAllLines(inputStream);
        }

        return new ByteArrayInputStream(this.cachedInputStreamContent.getBytes());
    }
}