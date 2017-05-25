package app.waste_disposal.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ProcessingDataImpl;

public class BurnableDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double volume = garbage.getVolumePerKg() * garbage.getWeight();

        double energy = volume - (0.2 * volume);
        double capital = 0;

        return new ProcessingDataImpl(energy, capital);
    }
}