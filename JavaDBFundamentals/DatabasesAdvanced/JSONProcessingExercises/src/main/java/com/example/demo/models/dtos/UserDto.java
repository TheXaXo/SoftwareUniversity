package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;

public class UserDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    public UserDto() {
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
}