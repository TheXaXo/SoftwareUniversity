package app.waste_disposal.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ProcessingDataImpl;

public class StorableDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double volume = garbage.getVolumePerKg() * garbage.getWeight();

        double energy = 0 - (0.13 * volume);
        double capital = 0 - (0.65 * volume);

        return new ProcessingDataImpl(energy, capital);
    }
}
