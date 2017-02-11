import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] boundNumbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lowerBound = Math.min(boundNumbers[0], boundNumbers[1]);
        int upperBound = Math.max(boundNumbers[0], boundNumbers[1]);

        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(number -> lowerBound <= number && upperBound >= number)
                .forEach(number -> System.out.print(number + " "));
    }
}