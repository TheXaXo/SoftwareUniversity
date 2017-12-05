package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    void save(List<User> users);
}