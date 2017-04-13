package models.boats;

import contracts.Race;
import utility.Validator;

public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    public int getOars() {
        return oars;
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.getOars() * 100D) - this.getWeight() + race.getOceanCurrentSpeed();
    }
}