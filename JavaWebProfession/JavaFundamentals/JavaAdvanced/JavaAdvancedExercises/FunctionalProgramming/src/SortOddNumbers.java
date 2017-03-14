import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Function;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] items = reader.readLine().split(", ");

        Function<String, Integer> parseNums = numStr -> Integer.parseInt(numStr);

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String item : items) {
            numbers.add(parseNums.apply(item));
        }

        numbers.removeIf(n -> n % 2 != 0);

        StringBuilder output = new StringBuilder();

        for (int number : numbers) {
            output.append(number).append(", ");
        }

        System.out.println(output.substring(0, output.length() - 2));

        numbers.sort((a, b) -> a.compareTo(b));

        output = new StringBuilder();

        for (int number : numbers) {
            output.append(number).append(", ");
        }

        System.out.println(output.substring(0, output.length() - 2));
    }
}