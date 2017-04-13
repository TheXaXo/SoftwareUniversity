package factories;

import contracts.BoatFactory;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;
import models.boats.*;
import models.engines.BoatEngine;

public class BoatFactoryImpl implements BoatFactory {

    @Override
    public Boat createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        return new RowBoat(model, weight, oars);
    }

    @Override
    public Boat createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        return new SailBoat(model, weight, sailEfficiency);
    }

    @Override
    public Boat createPowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) throws NonExistentModelException, DuplicateModelException {
        return new PowerBoat(model, weight, firstEngine, secondEngine);
    }

    @Override
    public Boat createYacht(String model, int weight, BoatEngine engine, int cargoWeight) throws NonExistentModelException, DuplicateModelException {
        return new Yacht(model, weight, engine, cargoWeight);
    }
}