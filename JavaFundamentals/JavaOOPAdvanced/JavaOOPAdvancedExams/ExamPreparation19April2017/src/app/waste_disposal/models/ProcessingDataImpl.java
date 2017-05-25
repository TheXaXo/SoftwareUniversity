package app.waste_disposal.models;

import app.waste_disposal.contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData {

    private double energy;
    private double capital;

    public ProcessingDataImpl(double energy, double capital) {
        this.energy = energy;
        this.capital = capital;
    }

    @Override
    public double getEnergyBalance() {
        return this.energy;
    }

    @Override
    public double getCapitalBalance() {
        return this.capital;
    }
}