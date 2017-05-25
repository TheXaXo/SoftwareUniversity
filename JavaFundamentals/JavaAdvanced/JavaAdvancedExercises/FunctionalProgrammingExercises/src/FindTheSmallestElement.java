import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> printIndexOfRightmostSmallest = allNumbers -> {
            int smallestNumber = Integer.MAX_VALUE;
            int smallestIndex = 0;

            for (int i = 0; i < allNumbers.length; i++) {
                int currentNumber = allNumbers[i];

                if (currentNumber <= smallestNumber) {
                    smallestNumber = currentNumber;
                    smallestIndex = i;
                }
            }

            System.out.println(smallestIndex);
        };

        printIndexOfRightmostSmallest.accept(numbers);
    }
}