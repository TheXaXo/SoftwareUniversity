package barracksWars.core.factories;

import barracksWars.contracts.Unit;
import barracksWars.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> unit = Class.forName("barracksWars.models.units." + unitType);

        return (Unit) unit.getDeclaredConstructor().newInstance();
    }
}