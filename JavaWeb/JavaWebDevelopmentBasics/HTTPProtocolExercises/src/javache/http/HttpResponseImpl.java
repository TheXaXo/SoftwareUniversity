package javache.http;

import javache.WebConstants;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpResponseImpl implements HttpResponse {
    private int statusCode;
    private HashMap<String, String> headers;
    private byte[] content;

    public HttpResponseImpl() {
        this.headers = new LinkedHashMap<>();
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return this.content;
    }

    @Override
    public byte[] getBytes() {
        String codeText = null;

        switch (this.statusCode) {
            case 200:
                codeText = "OK";
                break;
            case 400:
                codeText = "Bad Request";
                break;
            case 401:
                codeText = "Unauthorized";
                break;
            case 404:
                codeText = "Not Found";
                break;
            case 500:
                codeText = "Internal Server Error";
                break;
        }

        //Response line
        StringBuilder responseLineSb = new StringBuilder();
        responseLineSb.append("HTTP/1.1 ").append(this.getStatusCode()).append(" ").append(codeText).append(System.lineSeparator());
        responseLineSb.append(WebConstants.SERVER_HEADER_NAME_AND_VERSION).append(System.lineSeparator());
        responseLineSb.append(WebConstants.DATE_HEADER).append(new Date()).append(System.lineSeparator());

        byte[] responseLineAsBytes = responseLineSb.toString().getBytes();

        //Headers
        StringBuilder headersSb = new StringBuilder();

        for (Map.Entry<String, String> headerValue : this.getHeaders().entrySet()) {
            headersSb.append(headerValue.getKey()).append(headerValue.getValue()).append(System.lineSeparator());
        }

        headersSb.append(System.lineSeparator());

        byte[] headersAsBytes = headersSb.toString().getBytes();

        //Full data
        byte[] fullResponseByteData = new byte[responseLineAsBytes.length + headersAsBytes.length + this.getContent().length];

        for (int i = 0; i < responseLineAsBytes.length; i++) {
            fullResponseByteData[i] = responseLineAsBytes[i];
        }

        for (int i = 0; i < headersAsBytes.length; i++) {
            fullResponseByteData[i + responseLineAsBytes.length] = headersAsBytes[i];
        }

        for (int i = 0; i < content.length; i++) {
            fullResponseByteData[i + responseLineAsBytes.length + headersAsBytes.length] = content[i];
        }

        return fullResponseByteData;
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }
}