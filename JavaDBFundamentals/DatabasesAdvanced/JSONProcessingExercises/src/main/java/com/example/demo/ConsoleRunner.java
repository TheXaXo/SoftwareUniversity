package com.example.demo;

import com.example.demo.io.JSONReader;
import com.example.demo.io.JSONWriter;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.models.dtos.CategoryDto;
import com.example.demo.models.dtos.ProductDto;
import com.example.demo.models.dtos.UserDto;
import com.example.demo.models.dtos.exercisesDtos.Query1ProductDto;
import com.example.demo.services.CategoryServiceImpl;
import com.example.demo.services.ProductServiceImpl;
import com.example.demo.services.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private JSONReader jsonReader;
    private JSONWriter jsonWriter;
    private UserServiceImpl userService;
    private ProductServiceImpl productService;
    private CategoryServiceImpl categoryService;
    private ModelMapper mapper;

    @Autowired
    public ConsoleRunner(JSONReader jsonReader, JSONWriter jsonWriter, UserServiceImpl userService, ProductServiceImpl productService, CategoryServiceImpl categoryService) {
        this.jsonReader = jsonReader;
        this.jsonWriter = jsonWriter;
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.mapper = new ModelMapper();
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.seedDatabase();
        List<Product> products = this.productService.findAllByPriceBetween(new BigDecimal("100"), new BigDecimal("500"));
        List<Query1ProductDto> productDtos = new ArrayList<>();

        TypeMap<Product, Query1ProductDto> typeMap = mapper.createTypeMap(Product.class, Query1ProductDto.class);
        typeMap.addMapping(src -> src.getSeller().getLastName(), Query1ProductDto::setSeller);

        for (Product product : products) {
            productDtos.add(typeMap.map(product));
        }

        this.jsonWriter.write("C:\\Users\\TheXaXo\\Documents\\SoftwareUniversity\\JavaDBFundamentals\\DatabasesAdvanced\\JSONProcessingExercises\\src\\main\\resources\\files\\out\\products.json", productDtos);
    }

    private void seedDatabase() throws FileNotFoundException {
        List<User> users = this.jsonReader.getObjectsFromFile(
                "C:\\Users\\TheXaXo\\Documents\\SoftwareUniversity\\JavaDBFundamentals\\DatabasesAdvanced\\JSONProcessingExercises\\src\\main\\resources\\files\\users.json",
                User.class, UserDto[].class);
        List<Category> categories = this.jsonReader.getObjectsFromFile(
                "C:\\Users\\TheXaXo\\Documents\\SoftwareUniversity\\JavaDBFundamentals\\DatabasesAdvanced\\JSONProcessingExercises\\src\\main\\resources\\files\\categories.json",
                Category.class, CategoryDto[].class);
        List<Product> products = this.jsonReader.getObjectsFromFile(
                "C:\\Users\\TheXaXo\\Documents\\SoftwareUniversity\\JavaDBFundamentals\\DatabasesAdvanced\\JSONProcessingExercises\\src\\main\\resources\\files\\products.json",
                Product.class, ProductDto[].class);

        Random random = new Random();

        for (Product product : products) {
            product.setSeller(users.get(random.nextInt(users.size())));

            if (random.nextInt(100) > 50) {
                product.setBuyer(users.get(random.nextInt(users.size())));
            }
        }

        this.userService.save(users);
        this.categoryService.save(categories);
        this.productService.save(products);
    }
}