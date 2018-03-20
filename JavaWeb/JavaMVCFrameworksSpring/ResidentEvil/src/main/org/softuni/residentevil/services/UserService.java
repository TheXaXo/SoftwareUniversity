package org.softuni.residentevil.services;

import org.softuni.residentevil.entities.User;
import org.softuni.residentevil.models.RegisterUserBindingModel;

public interface UserService {
    void save(RegisterUserBindingModel bindingModel);

    boolean userWithUsernameExists(String username);

    boolean userWithEmailExists(String email);

    User getUserByUsername(String username);
}
