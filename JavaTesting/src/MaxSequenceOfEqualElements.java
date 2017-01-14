import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(a -> Integer.parseInt(a))
                .toArray();

        int mostFrequentNumberIndex = 0;
        int maxCount = 0;
        int count = 1;
        int number;

        for (int i = 0; i < input.length; i++) {
            number = input[i];

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] == number) {
                    count++;
                } else {
                    count = 1;
                    break;
                }

                if (count > maxCount) {
                    mostFrequentNumberIndex = i;
                    maxCount = count;
                }

                if (j == input.length - 1) {
                    count = 1;
                }
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(input[mostFrequentNumberIndex] + " ");
        }
    }
}