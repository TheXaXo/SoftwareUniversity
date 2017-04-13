package models.boats;

import contracts.Race;
import utility.Constants;

public class SailBoat extends Boat {

    private static final int MIN_SAIL_EFFICIENCY = 1;
    private static final int MAX_SAIL_EFFICIENCY = 100;

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    public int getSailEfficiency() {
        return sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < MIN_SAIL_EFFICIENCY || sailEfficiency > MAX_SAIL_EFFICIENCY) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (race.getWindSpeed() * (this.getSailEfficiency() / 100D)) - this.getWeight() + (race.getOceanCurrentSpeed() / 2D);
    }
}