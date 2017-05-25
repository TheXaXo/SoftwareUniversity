package models.engines;

import contracts.Modelable;

public class SterndriveBoatEngine extends BoatEngine implements Modelable {
    private static final int MULTIPLIER = 7;

    public SterndriveBoatEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (super.getHorsePower() * MULTIPLIER) + super.getDisplacement();
    }
}