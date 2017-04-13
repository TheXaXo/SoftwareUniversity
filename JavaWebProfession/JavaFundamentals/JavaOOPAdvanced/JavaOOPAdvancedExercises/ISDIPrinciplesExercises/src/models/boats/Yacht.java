package models.boats;

import contracts.Race;
import models.engines.BoatEngine;
import utility.Validator;

public class Yacht extends Boat {

    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine boatEngine, int cargoWeight) {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.setCargoWeight(cargoWeight);
        super.setMotorBoat(true);
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.boatEngine.getOutput() - (this.getWeight() + this.getCargoWeight()) + (race.getOceanCurrentSpeed() / 2D);
    }
}