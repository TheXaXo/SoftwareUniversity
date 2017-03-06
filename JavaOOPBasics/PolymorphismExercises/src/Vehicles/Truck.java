package Vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(super.getFuelConsumption() + 1.6);
    }

    @Override
    public void drive(double distance) {
        double fuelRequired = distance * super.getFuelConsumption();

        if (fuelRequired > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Truck needs refueling");
        } else {
            super.setFuelQuantity(super.getFuelQuantity() - fuelRequired);
        }
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + (fuel * 0.95));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}