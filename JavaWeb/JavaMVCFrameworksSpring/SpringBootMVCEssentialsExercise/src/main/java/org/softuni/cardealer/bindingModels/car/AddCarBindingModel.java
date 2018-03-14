package org.softuni.cardealer.bindingModels.car;

public class AddCarBindingModel {
    private String make;
    private String model;
    private long travelledDistance;
    private String partsId;

    public AddCarBindingModel() {

    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public String getPartsId() {
        return this.partsId;
    }

    public void setPartsId(String partsId) {
        this.partsId = partsId;
    }
}