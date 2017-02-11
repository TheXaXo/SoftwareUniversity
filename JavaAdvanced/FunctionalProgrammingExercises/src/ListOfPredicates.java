import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        if (n < 1) {
            return;
        }

        int[] divisors = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        BiPredicate<Integer, int[]> isDivisableByDivisors = (numberToCheck, allDivisors) -> {
            for (int divisor : allDivisors) {
                if (numberToCheck % divisor != 0) {
                    return false;
                }
            }

            return true;
        };

        for (int number : numbers) {
            if (isDivisableByDivisors.test(number, divisors)) {
                System.out.print(number + " ");
            }
        }
    }
}
