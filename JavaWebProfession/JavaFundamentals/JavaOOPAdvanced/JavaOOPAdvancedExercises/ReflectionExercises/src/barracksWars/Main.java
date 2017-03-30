package barracksWars;

import barracksWars.contracts.Repository;
import barracksWars.contracts.Runnable;
import barracksWars.contracts.UnitFactory;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        Runnable engine = new Engine(repository, unitFactory);

        engine.run();
    }
}
