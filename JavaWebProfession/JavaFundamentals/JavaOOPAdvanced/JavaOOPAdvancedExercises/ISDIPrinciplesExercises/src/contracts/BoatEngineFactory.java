package contracts;

import enumeration.EngineType;
import exeptions.DuplicateModelException;
import models.engines.BoatEngine;

public interface BoatEngineFactory {

    BoatEngine createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;
}