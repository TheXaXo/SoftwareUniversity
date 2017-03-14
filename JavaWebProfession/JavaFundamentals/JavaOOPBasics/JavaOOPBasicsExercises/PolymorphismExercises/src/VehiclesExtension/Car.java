package VehiclesExtension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
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
        if (fuel > super.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
