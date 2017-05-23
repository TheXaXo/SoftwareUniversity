package cresla.entities.reactors;

public class CryoReactor extends BaseReactor {

    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long totalEnergy = super.getTotalEnergyOutput() * this.cryoProductionIndex;

        if (totalEnergy > super.getTotalHeatAbsorbing()) {
            return 0;
        }

        return totalEnergy;
    }

    @Override
    public String toString() {
        return String.format("%s - %d\nEnergy Output: %d\nHeat Absorbing: %d\nModules: %d",
                "CryoReactor",
                super.getId(),
                this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(),
                super.getModuleCount());
    }
}