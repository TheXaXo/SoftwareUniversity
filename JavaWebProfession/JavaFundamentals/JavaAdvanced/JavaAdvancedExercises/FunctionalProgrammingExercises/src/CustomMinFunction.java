import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findMin = allNumbers -> {
            int minNum = Integer.MAX_VALUE;

            for (int number : allNumbers) {
                if (number < minNum) {
                    minNum = number;
                }
            }

            return minNum;
        };

        System.out.println(findMin.apply(numbers));
    }
}
