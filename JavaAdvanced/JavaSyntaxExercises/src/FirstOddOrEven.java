import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FirstOddOrEven {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] numbers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] split = console.nextLine().split("\\s");

        int count = Integer.parseInt(split[1]);
        String command = split[2];

        System.out.println(getFirstN(numbers, count, command));

    }

    public static String getFirstN(int[] numbers, int count, String command) {
        StringBuilder sb = new StringBuilder();
        int numbersAddedCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (command.equals("even")) {
                if (numbers[i] % 2 == 0) {
                    sb.append(Integer.toString(numbers[i]));
                    sb.append(" ");
                    numbersAddedCount++;
                }
            } else {
                if (numbers[i] % 2 != 0) {
                    sb.append(Integer.toString(numbers[i]));
                    sb.append(" ");
                    numbersAddedCount++;
                }
            }

            if (numbersAddedCount >= count) {
                break;
            }
        }

        return sb.toString();
    }
}