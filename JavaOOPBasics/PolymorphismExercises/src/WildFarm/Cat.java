package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType,
               double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.######");

        return String.format("Cat[%s, %s, %s, %s, %d]",
                super.getAnimalName(), this.getBreed(), format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}