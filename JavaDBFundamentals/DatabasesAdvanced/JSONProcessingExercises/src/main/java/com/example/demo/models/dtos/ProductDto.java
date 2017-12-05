package com.example.demo.models.dtos;

import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    private User buyer;
    private User seller;

    public ProductDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return this.buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return this.seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}