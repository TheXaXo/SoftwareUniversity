package cresla.entities.modules;

public class CooldownSystem extends BaseAbsorberModule {

    public CooldownSystem(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        //TODO might be an error with the printing
        return String.format("%s Module - %d\nHeat Absorbing: %d",
                "CooldownSystem",
                super.getId(),
                super.getHeatAbsorbing());
    }
}
