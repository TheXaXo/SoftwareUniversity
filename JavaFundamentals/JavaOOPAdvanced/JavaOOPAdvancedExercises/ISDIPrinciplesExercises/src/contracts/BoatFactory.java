package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;
import models.boats.Boat;
import models.engines.BoatEngine;

public interface BoatFactory {

    Boat createRowBoat(String model, int weight, int oars) throws DuplicateModelException;

    Boat createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException;

    Boat createPowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) throws NonExistentModelException, DuplicateModelException;

    Boat createYacht(String model, int weight, BoatEngine engine, int cargoWeight) throws NonExistentModelException, DuplicateModelException;
}