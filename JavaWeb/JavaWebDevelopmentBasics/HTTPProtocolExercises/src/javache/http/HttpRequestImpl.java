package javache.http;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HttpRequestImpl implements HttpRequest {
    private String method;
    private String requestUrl;
    private HashMap<String, String> headers;
    private HashMap<String, String> bodyParameters;

    public HttpRequestImpl(String requestContent) {
        this.headers = new LinkedHashMap<>();
        this.bodyParameters = new LinkedHashMap<>();
        this.parseRequestContent(requestContent);
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return this.bodyParameters;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return this.requestUrl.contains(".");
    }

    private void parseRequestContent(String requestContent) {
        String[] data = requestContent.split("\r\n");

        String method = this.extractMethod(data[0]);
        this.setMethod(method);

        String requestUrl = this.extractResource(data[0]);
        this.setRequestUrl(requestUrl);

        int line = 1;
        while (!data[line].equals("<CRLF>")) {
            String[] keyValue = data[line].split(": ");
            this.addHeader(keyValue[0], keyValue[1]);
            line++;

            if (line >= data.length) {
                break;
            }
        }

        //TODO handle post requests
    }

    private String extractMethod(String content) {
        return content.split("\\s")[0];
    }

    private String extractResource(String content) {
        return content.split("\\s")[1];
    }
}