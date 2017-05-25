package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {

    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}