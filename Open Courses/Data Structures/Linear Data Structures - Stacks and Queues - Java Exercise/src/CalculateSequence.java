import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int startNumber = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(startNumber);

        int[] allNumbers = new int[50];

        for (int i = 0; i < 50; i++) {
            int number = queue.removeFirst();
            allNumbers[i] = number;

            queue.addLast(number + 1);
            queue.addLast(number * 2 + 1);
            queue.addLast(number + 2);
        }

        for (int i = 0; i < allNumbers.length; i++) {
            System.out.print(allNumbers[i]);

            if (i < 49) {
                System.out.print(", ");
            }
        }
    }
}