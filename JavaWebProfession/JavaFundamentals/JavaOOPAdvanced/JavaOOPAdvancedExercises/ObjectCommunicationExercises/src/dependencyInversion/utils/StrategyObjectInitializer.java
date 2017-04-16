package dependencyInversion.utils;

import dependencyInversion.Operation;
import dependencyInversion.strategies.Strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StrategyObjectInitializer {

    private static final String PACKAGE_LOCATION = "dependencyInversion.strategies.";
    private static final String CLASS_SUFFIX = "Strategy";

    @SuppressWarnings("unchecked")
    public static Strategy getStrategyFromValue(char value) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Operation operation : Operation.values()) {
            if (operation.getOperationSymbol() == value) {
                String className = PACKAGE_LOCATION + operation + CLASS_SUFFIX;

                Class<Strategy> classToInitialize = (Class<Strategy>) Class.forName(className);
                Constructor<Strategy> constructor = classToInitialize.getConstructor();

                return constructor.newInstance();
            }
        }

        return null;
    }
}