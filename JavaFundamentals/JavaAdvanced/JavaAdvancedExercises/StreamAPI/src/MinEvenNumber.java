import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] numbers = Arrays.stream(reader.readLine().split(" "))
                .filter(a -> !a.isEmpty())
                .mapToDouble(Double::parseDouble)
                .toArray();

        OptionalDouble result = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .min();

        if (result.isPresent()) {
            System.out.printf("%.2f", result.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}