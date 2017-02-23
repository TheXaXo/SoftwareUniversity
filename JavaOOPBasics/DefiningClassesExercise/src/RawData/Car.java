package RawData;

import java.util.ArrayList;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private ArrayList<Tire> tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);

        this.tires = new ArrayList<>();

        this.tires.add(new Tire(tire1Pressure, tire1Age));
        this.tires.add(new Tire(tire2Pressure, tire2Age));
        this.tires.add(new Tire(tire3Pressure, tire3Age));
        this.tires.add(new Tire(tire4Pressure, tire4Age));
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public ArrayList<Tire> getTires() {
        return this.tires;
    }
}