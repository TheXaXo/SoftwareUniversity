package org.softuni.cardealer.bindingModels.user;

public class LoginUserBindingModel {
    private String username;
    private String password;

    public LoginUserBindingModel() {

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}