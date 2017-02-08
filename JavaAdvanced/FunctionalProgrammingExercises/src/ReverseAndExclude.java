import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberToCheck = Integer.parseInt(reader.readLine());

        BiConsumer<int[], Integer> reverseAndExcludeNumber = (allNumbers, numberToExclude) -> {
            for (int i = allNumbers.length - 1; i >= 0; i--) {
                if (allNumbers[i] % numberToExclude != 0) {
                    System.out.printf("%d ", allNumbers[i]);
                }
            }
        };

        reverseAndExcludeNumber.accept(numbers, numberToCheck);
    }
}