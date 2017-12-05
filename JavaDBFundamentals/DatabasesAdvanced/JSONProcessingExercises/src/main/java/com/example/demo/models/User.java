package com.example.demo.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    @Length(min = 3)
    private String lastName;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "seller")
    private Set<Product> sold;

    @OneToMany(mappedBy = "buyer")
    private Set<Product> bought;

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    public User() {
    }

    public User(String firstName, String lastName, int age, Set<Product> sold, Set<Product> bought) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sold = sold;
        this.bought = bought;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Product> getSold() {
        return this.sold;
    }

    public void setSold(Set<Product> sold) {
        this.sold = sold;
    }

    public Set<Product> getBought() {
        return this.bought;
    }

    public void setBought(Set<Product> bought) {
        this.bought = bought;
    }

    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}