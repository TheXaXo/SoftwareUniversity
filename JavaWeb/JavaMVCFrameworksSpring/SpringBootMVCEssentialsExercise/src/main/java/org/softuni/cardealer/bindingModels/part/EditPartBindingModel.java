package org.softuni.cardealer.bindingModels.part;

public class EditPartBindingModel {
    private double price;
    private int quantity;

    public EditPartBindingModel() {

    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}