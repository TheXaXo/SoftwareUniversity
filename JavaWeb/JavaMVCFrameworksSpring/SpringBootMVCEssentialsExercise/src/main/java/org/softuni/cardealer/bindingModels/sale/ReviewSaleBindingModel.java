package org.softuni.cardealer.bindingModels.sale;

public class ReviewSaleBindingModel {
    private long carId;
    private long customerId;
    private double discount;

    public ReviewSaleBindingModel() {

    }

    public long getCarId() {
        return this.carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}