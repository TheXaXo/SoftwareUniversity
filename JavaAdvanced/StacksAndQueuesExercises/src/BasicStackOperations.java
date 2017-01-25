import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] commandSplit = console.nextLine().split("\\s");

        int numberOfElementsToPush = Integer.parseInt(commandSplit[0]);
        int numberOfElementsToPop = Integer.parseInt(commandSplit[1]);

        int numberToSearchFor = Integer.parseInt(commandSplit[2]);

        commandSplit = console.nextLine().split("\\s");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int elementsPushed = 0;

        for (String number : commandSplit) {
            if (elementsPushed < numberOfElementsToPush) {
                stack.push(Integer.parseInt(number));
            }
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if (stack.size() == 0) {
            System.out.println(0);
            return;
        }

        if (stack.contains(numberToSearchFor)) {
            System.out.println(true);
        } else {
            int smallestNumber = Integer.MAX_VALUE;

            while (!stack.isEmpty()) {
                int number = stack.pop();

                if (number < smallestNumber) {
                    smallestNumber = number;
                }
            }

            System.out.println(smallestNumber);
        }
    }
}