package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.User;
import org.softuni.cardealer.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void register(User user) {
        this.repository.saveAndFlush(user);
    }

    public User findUserByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public User findUserByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public User findUserById(long id) {
        return this.repository.findById(id);
    }
}