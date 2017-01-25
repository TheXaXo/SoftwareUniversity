import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long number = console.nextLong();

        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.add(number);

        for (int i = 0; i < 50; i++) {
            long element = queue.remove();

            long s2 = element + 1;
            long s3 = 2 * element + 1;
            long s4 = element + 2;

            queue.add(s2);
            queue.add(s3);
            queue.add(s4);

            System.out.print(element + " ");
        }
    }
}