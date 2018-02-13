import org.softuni.javache.http.*;
import org.softuni.javache.io.Reader;
import org.softuni.javache.io.Writer;
import org.softuni.javache.lib.handler.AbstractRequestHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToyoteResourceHandler extends AbstractRequestHandler {
    private boolean intercepted;

    public ToyoteResourceHandler(String serverPath) {
        super(serverPath);
    }

    private void retrieveResource(HttpRequest request, HttpResponse response) throws IOException {
        Path resourcePath = Paths.get(super.serverPath + "/static" + request.getRequestUrl());
        byte[] fileContentData = Files.readAllBytes(resourcePath);
        String fileContentType = Files.probeContentType(resourcePath);

        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", fileContentType);
        response.addHeader("Content-Length", fileContentData.length + "");
        response.addHeader("Content-Disposition", "inline");

        response.setContent(fileContentData);
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        try {
            String requestContent = Reader.readAllLines(inputStream);

            HttpRequest request = new HttpRequestImpl(requestContent);
            HttpResponse response = new HttpResponseImpl();

            this.retrieveResource(request, response);

            Writer.writeBytes(response.getBytes(), outputStream);
            this.intercepted = true;
        } catch (IOException e) {
            this.intercepted = false;
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.intercepted;
    }
}
