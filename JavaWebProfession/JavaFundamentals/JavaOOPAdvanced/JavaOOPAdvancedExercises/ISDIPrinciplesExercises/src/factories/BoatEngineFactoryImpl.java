package factories;

import contracts.BoatEngineFactory;
import enumeration.EngineType;
import exeptions.DuplicateModelException;
import models.engines.BoatEngine;
import models.engines.JetBoatEngine;
import models.engines.SterndriveBoatEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BoatEngineFactoryImpl implements BoatEngineFactory {

    @Override
    public BoatEngine createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {

        switch (engineType) {
            case JET:
                return new JetBoatEngine(model, horsepower, displacement);
            case STERNDRIVE:
                return new SterndriveBoatEngine(model, horsepower, displacement);
            default:
                throw new NotImplementedException();
        }
    }
}