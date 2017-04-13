package models.engines;

import contracts.Modelable;

public class JetBoatEngine extends BoatEngine implements Modelable {
    private static final int MULTIPLIER = 5;

    public JetBoatEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (super.getHorsePower() * MULTIPLIER) + super.getDisplacement();
    }
}