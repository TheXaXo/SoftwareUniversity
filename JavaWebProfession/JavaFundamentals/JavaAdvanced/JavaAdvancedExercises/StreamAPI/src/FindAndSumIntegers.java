import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .filter(a -> {
                    try {
                        int num = Integer.parseInt(a);
                    } catch (Exception ex) {
                        return false;
                    }

                    return true;
                })
                .mapToInt(Integer::parseInt)
                .toArray();

        if (numbers.length == 0) {
            System.out.println("No match");
        } else {
            System.out.println(Arrays.stream(numbers).sum());
        }
    }
}