import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] numbers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(a -> Integer.parseInt(a))
                .toArray();

        int count = 1;
        int maxCount = 0;
        int mostFrequentNumber = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFrequentNumber = numbers[i];
            }

            count = 1;
        }

        System.out.println(mostFrequentNumber);
    }
}