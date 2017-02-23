package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPerKilometer;
    private double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKilometer = fuelPerKilometer;
    }

    public void move(double kilometers) {
        if (fuelPerKilometer * kilometers > fuelAmount) {
            throw new IllegalStateException();
        } else {
            this.fuelAmount -= fuelPerKilometer * kilometers;
            this.distanceTravelled += kilometers;
        }
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getDistanceTravelled() {
        return this.distanceTravelled;
    }
}