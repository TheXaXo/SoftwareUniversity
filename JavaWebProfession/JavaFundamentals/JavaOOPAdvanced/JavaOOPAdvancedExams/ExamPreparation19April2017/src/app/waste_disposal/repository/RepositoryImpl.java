package app.waste_disposal.repository;

public class RepositoryImpl implements Repository {

    private double energy;
    private double capital;

    @Override
    public void addEnergy(double energy) {
        this.energy += energy;
    }

    @Override
    public void addCapital(double capital) {
        this.capital += capital;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public double getCapital() {
        return this.capital;
    }
}