import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] commandSplit = console.nextLine().split("\\s");

        int countOfNumbersToAdd = Integer.parseInt(commandSplit[0]);
        int countOfNumbersToRemove = Integer.parseInt(commandSplit[1]);

        int numberToCheck = Integer.parseInt(commandSplit[2]);

        commandSplit = console.nextLine().split("\\s");

        int numbersAdded = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (String number : commandSplit) {
            if (numbersAdded >= countOfNumbersToAdd) {
                break;
            }

            queue.add(Integer.parseInt(number));
            numbersAdded++;
        }

        for (int i = 0; i < countOfNumbersToRemove; i++) {
            queue.remove();
        }

        if (queue.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            int minNumber = Integer.MAX_VALUE;

            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }

            while (!queue.isEmpty()) {
                int number = queue.remove();

                if (number < minNumber) {
                    minNumber = number;
                }
            }

            System.out.println(minNumber);
        }
    }
}