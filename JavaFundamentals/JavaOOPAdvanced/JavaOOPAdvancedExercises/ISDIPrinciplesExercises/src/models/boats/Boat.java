package models.boats;

import contracts.Modelable;
import contracts.Race;
import utility.Constants;
import utility.Validator;

public abstract class Boat implements Modelable {
    private String model;
    private int weight;
    private boolean isMotorBoat;

    public Boat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    public boolean isMotorBoat() {
        return isMotorBoat;
    }

    public void setMotorBoat(boolean motorBoat) {
        isMotorBoat = motorBoat;
    }

    public abstract double calculateRaceSpeed(Race race);

    public double getRaceTime(Race race) {
        return race.getDistance() / this.calculateRaceSpeed(race);
    }
}