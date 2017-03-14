package VehiclesExtension;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.4, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double requiredFuel = super.getFuelConsumption() * distance;

        if (requiredFuel > super.getFuelQuantity()) {
            throw new IllegalArgumentException("Bus needs refueling");
        } else {
            super.setFuelQuantity(super.getFuelQuantity() - requiredFuel);
        }
    }

    public void driveEmpty(double distance) {
        super.setFuelConsumption(super.getFuelConsumption() - 1.4);
        this.drive(distance);
        super.setFuelConsumption(super.getFuelConsumption() + 1.4);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel > super.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}