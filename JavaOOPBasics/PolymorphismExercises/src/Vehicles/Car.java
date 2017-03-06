package Vehicles;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.setFuelConsumption(this.getFuelConsumption() + 0.9);
    }

    @Override
    public void drive(double distance) {
        double fuelRequired = distance * super.getFuelConsumption();

        if (fuelRequired > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Car needs refueling");
        } else {
            super.setFuelQuantity(super.getFuelQuantity() - fuelRequired);
        }
    }

    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
