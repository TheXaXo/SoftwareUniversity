package MordorsCrueltyPlan;

import java.util.ArrayList;

public class Gandalf {
    private ArrayList<Food> foodEaten;

    public Gandalf() {
        this.foodEaten = new ArrayList<>();
    }

    public void feed(Food food) {
        this.foodEaten.add(food);
    }

    public int calculatePointsOfHappiness() {
        return foodEaten.stream()
                .mapToInt(food -> food.getPointsOfHappiness())
                .sum();
    }

    public String getMood() {
        int pointsOfHappiness = this.calculatePointsOfHappiness();

        if (pointsOfHappiness < -5) {
            return "Angry";
        } else if (pointsOfHappiness < 0) {
            return "Sad";
        } else if (pointsOfHappiness < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}