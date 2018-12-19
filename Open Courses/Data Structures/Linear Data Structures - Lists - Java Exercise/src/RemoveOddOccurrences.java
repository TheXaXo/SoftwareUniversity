import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveOddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> numbersOccurrences = new HashMap<>();

        for (int number : numbers) {
            numbersOccurrences.putIfAbsent(number, 0);
            numbersOccurrences.put(number, numbersOccurrences.get(number) + 1);
        }

        for (int number : numbers) {
            if (numbersOccurrences.get(number) % 2 == 0) {
                System.out.print(number + " ");
            }
        }
    }
}