import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a % 2 == 0 && b % 2 != 0) {
                    return -1;
                } else if (a % 2 != 0 && b % 2 == 0) {
                    return 1;
                } else {
                    return a.compareTo(b);
                }
            }
        };

        Arrays.sort(numbers, customComparator);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
