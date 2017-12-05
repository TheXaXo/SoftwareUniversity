package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(List<Product> products) {
        this.productRepository.save(products);
    }

    @Override
    public List<Product> findAllByPriceBetween(BigDecimal price1, BigDecimal price2) {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(price1, price2);
    }
}