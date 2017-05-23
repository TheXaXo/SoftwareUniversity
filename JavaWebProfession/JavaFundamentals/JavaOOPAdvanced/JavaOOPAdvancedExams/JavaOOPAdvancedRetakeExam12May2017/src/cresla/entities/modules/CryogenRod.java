package cresla.entities.modules;

public class CryogenRod extends BaseEnergyModule {

    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }

    @Override
    public String toString() {
        //TODO might be an error with the printing
        return String.format("%s Module - %d\nEnergy Output: %d",
                "CryogenRod",
                super.getId(),
                super.getEnergyOutput());
    }
}
