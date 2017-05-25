package WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }

        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}