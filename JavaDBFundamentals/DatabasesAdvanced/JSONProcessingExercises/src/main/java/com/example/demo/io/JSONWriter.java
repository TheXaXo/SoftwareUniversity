package com.example.demo.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class JSONWriter {
    private Gson gson;

    public JSONWriter() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    public <T> void write(String filepath, List<T> objects) throws IOException {
        File file = new File(filepath);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        String objectsAsJson = this.gson.toJson(objects);

        try (OutputStream outputStream = new FileOutputStream(filepath);
             BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            bf.write(objectsAsJson);
        }
    }
}