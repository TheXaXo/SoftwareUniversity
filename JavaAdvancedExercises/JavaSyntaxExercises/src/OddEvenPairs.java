import java.util.Arrays;
import java.util.Scanner;

public class OddEvenPairs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] numbers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (numbers.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            int numberOne = numbers[i];
            int numberTwo = numbers[i + 1];

            if (numberOne % 2 != 0 && numberTwo % 2 != 0) {
                System.out.printf("%d, %d -> both are odd%n", numberOne, numberTwo);
            } else if (numberOne % 2 == 0 && numberTwo % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n", numberOne, numberTwo);
            } else {
                System.out.printf("%d, %d -> different%n", numberOne, numberTwo);
            }

            i++;
        }
    }
}