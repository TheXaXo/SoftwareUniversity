package com.example.demo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false, name = "name")
    @Length(min = 3)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

    public Product() {
    }

    public Product(String name, BigDecimal price, User seller, User buyer, Set<Category> categories) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.buyer = buyer;
        this.categories = categories;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getSeller() {
        return this.seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return this.buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}