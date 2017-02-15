import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        ArrayDeque<Integer> elements = new ArrayDeque<>();
        ArrayDeque<Integer> maxElements = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = console.nextLine().split(" ");

            int type = Integer.parseInt(command[0]);
            int number = 0;

            if (command.length > 1) {
                number = Integer.parseInt(command[1]);
            }

            if (type == 1) {
                elements.push(number);

                if (maxElements.isEmpty()) {
                    maxElements.push(number);
                } else {
                    if (number > maxElements.peek()) {
                        maxElements.push(number);
                    }
                }
            } else if (type == 2) {
                int removedNumber = elements.pop();

                if (maxElements.peek() == removedNumber) {
                    maxElements.pop();
                }
            } else {
                System.out.println(maxElements.peek());
            }
        }
    }
}