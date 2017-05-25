package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");

        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), format.format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}