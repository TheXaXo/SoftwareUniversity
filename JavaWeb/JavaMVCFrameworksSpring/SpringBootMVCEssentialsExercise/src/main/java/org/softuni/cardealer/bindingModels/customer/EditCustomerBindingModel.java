package org.softuni.cardealer.bindingModels.customer;

public class EditCustomerBindingModel {
    private String name;
    private String birthDate;

    public EditCustomerBindingModel() {

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