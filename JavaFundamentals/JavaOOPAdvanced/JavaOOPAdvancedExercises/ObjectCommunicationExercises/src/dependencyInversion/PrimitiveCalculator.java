package dependencyInversion;

import dependencyInversion.strategies.AdditionStrategy;
import dependencyInversion.strategies.Strategy;
import dependencyInversion.utils.StrategyObjectInitializer;

import java.lang.reflect.InvocationTargetException;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator() {
        this.strategy = new AdditionStrategy();
    }

    public void changeStrategy(char operator) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        this.strategy = StrategyObjectInitializer.getStrategyFromValue(operator);
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}