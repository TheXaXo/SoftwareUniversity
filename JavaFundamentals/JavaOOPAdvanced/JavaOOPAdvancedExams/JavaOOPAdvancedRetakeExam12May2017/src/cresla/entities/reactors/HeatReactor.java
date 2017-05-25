package cresla.entities.reactors;

public class HeatReactor extends BaseReactor {

    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        if (super.getTotalEnergyOutput() > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return super.getTotalEnergyOutput();
    }

    @Override
    public String toString() {
        return String.format("%s - %d\nEnergy Output: %d\nHeat Absorbing: %d\nModules: %d",
                "HeatReactor",
                super.getId(),
                this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(),
                super.getModuleCount());
    }
}