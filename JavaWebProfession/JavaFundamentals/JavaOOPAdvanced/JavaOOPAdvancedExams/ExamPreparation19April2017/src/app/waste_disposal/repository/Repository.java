package app.waste_disposal.repository;

public interface Repository {

    void addEnergy(double energy);

    void addCapital(double capital);

    double getEnergy();

    double getCapital();
}