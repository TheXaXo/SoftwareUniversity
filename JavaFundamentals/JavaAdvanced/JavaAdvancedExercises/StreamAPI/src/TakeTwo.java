import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(numbers)
                .distinct()
                .filter(num -> num >= 10 && num <= 20)
                .limit(2)
                .forEach(num -> System.out.print(num + " "));
    }
}
