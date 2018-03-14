package org.softuni.cardealer.bindingModels.customer;

import java.util.Date;

public class AddCustomerBindingModel {
    private String name;
    private String birthDate;

    public AddCustomerBindingModel() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}