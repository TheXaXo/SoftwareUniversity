package models.boats;

import contracts.Race;
import models.engines.BoatEngine;

public class PowerBoat extends Boat {

    private BoatEngine boatEngineOne;
    private BoatEngine boatEngineTwo;

    public PowerBoat(String model, int weight, BoatEngine boatEngineOne, BoatEngine boatEngineTwo) {
        super(model, weight);
        this.boatEngineOne = boatEngineOne;
        this.boatEngineTwo = boatEngineTwo;
        super.setMotorBoat(true);
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (boatEngineOne.getOutput() + boatEngineTwo.getOutput()) - this.getWeight() + (race.getOceanCurrentSpeed() / 5D);
    }
}