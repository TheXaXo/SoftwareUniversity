package app.waste_disposal;

import app.waste_disposal.annotations.BurningRequired;
import app.waste_disposal.annotations.RecyclingRequired;
import app.waste_disposal.annotations.StoringRequired;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.strategies.BurnableDisposalStrategy;
import app.waste_disposal.strategies.RecyclableDisposalStrategy;
import app.waste_disposal.strategies.StorableDisposalStrategy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private Map<Class, GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder() {
        this.strategies = new LinkedHashMap<>();

        this.addStrategy(BurningRequired.class, new BurnableDisposalStrategy());
        this.addStrategy(RecyclingRequired.class, new RecyclableDisposalStrategy());
        this.addStrategy(StoringRequired.class, new StorableDisposalStrategy());
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        this.strategies.put(annotationClass, strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        this.strategies.remove(annotationClass);
        return true;
    }
}