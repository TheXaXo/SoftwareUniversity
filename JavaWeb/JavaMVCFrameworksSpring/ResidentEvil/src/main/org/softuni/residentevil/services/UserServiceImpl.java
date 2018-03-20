package org.softuni.residentevil.services;

import org.softuni.residentevil.entities.User;
import org.softuni.residentevil.models.RegisterUserBindingModel;
import org.softuni.residentevil.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(RegisterUserBindingModel bindingModel) {
        User user = new User();

        user.setUsername(bindingModel.getUsername());
        user.setPassword(bindingModel.getPassword());
        user.setEmail(bindingModel.getEmail());
        user.setRole("USER");

        this.repository.save(user);
    }

    @Override
    public boolean userWithUsernameExists(String username) {
        return this.repository.findUserByUsername(username) != null;
    }

    @Override
    public boolean userWithEmailExists(String email) {
        return this.repository.findUserByEmail(email) != null;
    }

    @Override
    public User getUserByUsername(String username) {
        return this.repository.findUserByUsername(username);
    }
}