package cresla.entities.modules;

public class HeatProcessor extends BaseAbsorberModule {

    public HeatProcessor(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }


    @Override
    public String toString() {
        //TODO might be an error with the printing
        return String.format("%s Module - %d\nHeat Absorbing: %d",
                "HeatProcessor",
                super.getId(),
                super.getHeatAbsorbing());
    }
}