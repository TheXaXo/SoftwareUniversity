package org.softuni.cardealer.bindingModels.suppliers;

public class AddSupplierBindingModel {
    private String name;
    private String type;

    public AddSupplierBindingModel() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
