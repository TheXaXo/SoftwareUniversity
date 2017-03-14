package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random rnd;

    public RandomArrayList() {
        this.rnd = new Random();
    }

    public Object getRandomElement() {
        Object objectToReturn = super.get(rnd.nextInt(super.size()));
        super.remove(objectToReturn);

        return objectToReturn;
    }
}