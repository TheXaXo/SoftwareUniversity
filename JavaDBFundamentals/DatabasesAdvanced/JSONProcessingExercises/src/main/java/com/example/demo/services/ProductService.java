package com.example.demo.services;

import com.example.demo.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void save(List<Product> products);

    List<Product> findAllByPriceBetween(BigDecimal price1, BigDecimal price2);
}