import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SequenceNM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numsStr = reader.readLine().split(" ");

        int n = Integer.parseInt(numsStr[0]);
        int m = Integer.parseInt(numsStr[1]);

        if (m < n) {
            return;
        } else if (n == m) {
            System.out.println(n);
            return;
        }

        Deque<Item> itemsQueue = new ArrayDeque<>();
        itemsQueue.addLast(new Item(n, null));

        Item lastItem;

        while (true) {
            Item item = itemsQueue.removeFirst();

            Item plusOne = new Item(item.value + 1, item);
            plusOne.stepsRequired = item.stepsRequired + 1;

            Item plusTwo = new Item(item.value + 2, item);
            plusTwo.stepsRequired = item.stepsRequired + 1;

            Item multiplyByTwo = new Item(item.value * 2, item);
            multiplyByTwo.stepsRequired = item.stepsRequired + 1;

            if (plusOne.value == m) {
                lastItem = plusOne;
                break;
            } else if (plusTwo.value == m) {
                lastItem = plusTwo;
                break;
            } else if (multiplyByTwo.value == m) {
                lastItem = multiplyByTwo;
                break;
            }

            itemsQueue.addLast(plusOne);
            itemsQueue.addLast(plusTwo);
            itemsQueue.addLast(multiplyByTwo);
        }

        int[] items = new int[lastItem.stepsRequired + 1];

        for (int i = 0; i < items.length; i++) {
            items[i] = lastItem.value;
            lastItem = lastItem.previousItem;
        }

        for (int i = items.length - 1; i >= 0; i--) {
            System.out.print(items[i]);

            if (i != 0) {
                System.out.print(" -> ");
            }
        }
    }

    private static class Item {
        private int value;
        private Item previousItem;
        private int stepsRequired;

        private Item(int value, Item previousItem) {
            this.value = value;
            this.previousItem = previousItem;
        }
    }
}