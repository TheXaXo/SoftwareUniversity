import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] items = reader.readLine().split(", ");

        Function<String, Integer> numParser = numStr -> Integer.parseInt(numStr);

        int count = 0;
        int sum = 0;

        for (String item : items) {
            int numFromStr = numParser.apply(item);

            count++;
            sum += numFromStr;
        }

        System.out.printf("Count = %d%nSum = %d%n", count, sum);
    }
}