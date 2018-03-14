package org.softuni.cardealer.bindingModels.sale;

public class AddSaleBindingModel {
    private long customerId;
    private long carId;
    private int discount;

    public AddSaleBindingModel() {

    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCarId() {
        return this.carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}