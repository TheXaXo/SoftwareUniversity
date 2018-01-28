package javache;

import javache.http.HttpRequestImpl;
import javache.http.HttpResponseImpl;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
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

        byte[] content = this.getResource(request.getRequestUrl());

        response.setContent(content);
        response.setStatusCode(this.resourceStatusCode);
        response.addHeader(WebConstants.CONTENT_TYPE_HEADER, this.getContentType());
        response.addHeader(WebConstants.CONTENT_DISPOSITION_HEADER, WebConstants.CONTENT_DISPOSITION_VALUE_INLINE);
        response.addHeader(WebConstants.CONTENT_LENGTH_HEADER, Integer.toString(content.length));

        return response.getBytes();
    }

    private byte[] getResource(String resourceName) {
        byte[] fileByteData = null;

        try {
            fileByteData = Files.readAllBytes(Paths.get(WebConstants.RESOURCES_FOLDER + resourceName));
            this.resourceExtension = resourceName.substring(resourceName.lastIndexOf(".") + 1);
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