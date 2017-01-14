import java.util.*;
import java.util.stream.Collectors;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] numbers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedHashMap<Integer, Integer> numOccurrence = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int count = 0;

            if (numOccurrence.containsKey(number)) {
                continue;
            }

            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] == number) {
                    count++;
                }
            }

            numOccurrence.put(number, count);
        }

        ArrayList<Map.Entry<Integer, Integer>> numOccurrenceSorted = numOccurrence.entrySet()
                .stream()
                .sorted(Comparator.comparing(a -> a.getKey()))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<Integer, Integer> numberOccurrence : numOccurrenceSorted) {
            System.out.printf("%d -> %d%n", numberOccurrence.getKey(), numberOccurrence.getValue());
        }
    }
}