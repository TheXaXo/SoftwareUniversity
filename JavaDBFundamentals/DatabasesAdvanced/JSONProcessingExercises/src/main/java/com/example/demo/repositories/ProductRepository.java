package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal price1, BigDecimal price2);
}