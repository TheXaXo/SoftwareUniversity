import org.softuni.javache.http.HttpResponse;
import org.softuni.javache.http.HttpResponseImpl;
import org.softuni.javache.http.HttpStatus;
import org.softuni.javache.io.Writer;
import org.softuni.javache.lib.handler.AbstractRequestHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestResourceHandler extends AbstractRequestHandler {
    private boolean hasIntercepted;

    public TestResourceHandler(String serverPath) {
        super(serverPath);
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        HttpResponse response = new HttpResponseImpl();

        response.addHeader("Content-Type", "text/html");
        response.setStatusCode(HttpStatus.OK);
        response.setContent("<h1>Hello from test resource handler</h1>".getBytes());

        this.hasIntercepted = true;
        try {
            Writer.writeBytes(response.getBytes(), outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.hasIntercepted;
    }
}