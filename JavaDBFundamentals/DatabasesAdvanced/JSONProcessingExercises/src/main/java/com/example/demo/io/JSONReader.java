package com.example.demo.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class JSONReader {
    private Gson gson;
    private ModelMapper mapper;

    public JSONReader() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.mapper = new ModelMapper();
    }

    public <T, K> List<T> getObjectsFromFile(String filePath, Class<T> objectClass, Class<K[]> objectDtoArrayClass) throws FileNotFoundException {
        FileReader reader = new FileReader(filePath);
        K[] dtos = gson.fromJson(reader, objectDtoArrayClass);

        List<T> mappedObjects = new ArrayList<>();

        for (K dto : dtos) {
            T mapped = this.mapper.map(dto, objectClass);
            mappedObjects.add(mapped);
        }

        return mappedObjects;
    }
}