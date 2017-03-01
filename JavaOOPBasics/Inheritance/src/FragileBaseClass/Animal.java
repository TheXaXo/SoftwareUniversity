package FragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;

public class Animal {
    protected ArrayList<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        Collections.addAll(this.foodEaten, food);
    }
}