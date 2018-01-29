package javache;

import javache.http.HttpRequestImpl;
import javache.http.HttpResponseImpl;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RequestHandler {
    private String resourceExtension;
    private int resourceSize;
    private int resourceStatusCode;
    private HashMap<String, String> contentTypes;

    public RequestHandler() {
        this.seedContentTypes();
    }

    public byte[] handleRequest(String requestContent) {
        HttpRequestImpl request = new HttpRequestImpl(requestContent);
        HttpResponseImpl response = new HttpResponseImpl();

        byte[] content = this.getResource(request);

        response.setContent(content);
        response.setStatusCode(this.resourceStatusCode);
        response.addHeader(WebConstants.CONTENT_TYPE_HEADER, this.getContentType());
        response.addHeader(WebConstants.CONTENT_DISPOSITION_HEADER, WebConstants.CONTENT_DISPOSITION_VALUE_INLINE);

        if (content != null) {
            response.addHeader(WebConstants.CONTENT_LENGTH_HEADER, Integer.toString(content.length));
        }

        return response.getBytes();
    }

    private byte[] getResource(HttpRequestImpl request) {
        Path filePath;
        String resourceName = request.getRequestUrl();

        if (request.isResource()) {
            filePath = Paths.get(WebConstants.ASSETS_FOLDER + resourceName);
        } else {
            filePath = Paths.get(WebConstants.PAGES_FOLDER + resourceName + ".html");
        }

        byte[] fileByteData = null;

        try {
            fileByteData = Files.readAllBytes(filePath);
            String resourceExtension = resourceName.substring(resourceName.lastIndexOf(".") + 1);

            if (resourceExtension.equals(resourceName)) {
                resourceExtension = "html";
            }

            this.resourceExtension = resourceExtension;
            this.resourceSize = fileByteData.length;
            this.resourceStatusCode = 200;
        } catch (NoSuchFileException e) {
            this.resourceStatusCode = 404;
        } catch (AccessDeniedException e) {
            this.resourceStatusCode = 401;
        } catch (IOException e) {
            this.resourceStatusCode = 500;
            e.printStackTrace();
        }

        return fileByteData;
    }

    private void seedContentTypes() {
        this.contentTypes = new LinkedHashMap<>();

        this.contentTypes.put("png", "image/png");
        this.contentTypes.put("jpg", "image/jpeg");
        this.contentTypes.put("jpeg", "image/jpeg");
        this.contentTypes.put("html", "text/html");
    }

    private String getContentType() {
        if (this.contentTypes.containsKey(resourceExtension)) {
            return this.contentTypes.get(resourceExtension);
        }

        return "text/plain";
    }
}