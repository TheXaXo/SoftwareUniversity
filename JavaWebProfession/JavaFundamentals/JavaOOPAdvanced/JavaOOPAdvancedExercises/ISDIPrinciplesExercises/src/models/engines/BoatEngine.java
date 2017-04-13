package models.engines;

import contracts.Modelable;
import utility.Constants;
import utility.Validator;

public abstract class BoatEngine implements Modelable {

    private String model;

    private int horsePower;
    private int displacement;

    public BoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsePower(horsepower);
        this.setDisplacement(displacement);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        Validator.validatePropertyValue(horsePower, "Horsepower");
        this.horsePower = horsePower;
    }

    public int getDisplacement() {
        return displacement;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    public abstract int getOutput();
}