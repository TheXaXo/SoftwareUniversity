package app.waste_disposal.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.ProcessingDataImpl;

public class RecyclableDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double energy = 0 - (0.5 * garbage.getVolumePerKg() * garbage.getWeight());
        double capital = 400 * garbage.getWeight();

        return new ProcessingDataImpl(energy, capital);
    }
}