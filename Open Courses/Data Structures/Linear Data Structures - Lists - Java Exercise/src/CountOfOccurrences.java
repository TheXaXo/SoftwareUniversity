import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountOfOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> numbersOccurrences = new TreeMap<>();

        for (int number : numbers) {
            numbersOccurrences.putIfAbsent(number, 0);
            numbersOccurrences.put(number, numbersOccurrences.get(number) + 1);
        }

        for (Map.Entry<Integer, Integer> keyValuePair : numbersOccurrences.entrySet()) {
            System.out.printf("%d -> %d times\n", keyValuePair.getKey(), keyValuePair.getValue());
        }
    }
}