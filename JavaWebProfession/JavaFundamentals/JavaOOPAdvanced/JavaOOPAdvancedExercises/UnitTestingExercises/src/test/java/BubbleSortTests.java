import bubbleSort.Bubble;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BubbleSortTests {

    private List<Integer> items;

    @Before
    public void initializeList() {
        this.items = this.generateRandomList();
    }

    @Test
    public void testSorting() {

        List<Integer> clonedList = new ArrayList<>(this.items);
        Bubble.sort(this.items);

        Collections.sort(clonedList);

        boolean areSame = true;

        for (int i = 0; i < this.items.size(); i++) {
            if (!clonedList.get(i).equals(this.items.get(i))) {
                areSame = false;
                break;
            }
        }

        Assert.assertTrue(areSame);
    }

    private List<Integer> generateRandomList() {
        List<Integer> listToReturn = new ArrayList<>();

        Random rnd = new Random();

        for (int i = 0; i < rnd.nextInt(20); i++) {
            listToReturn.add(rnd.nextInt(50));
        }

        return listToReturn;
    }
}