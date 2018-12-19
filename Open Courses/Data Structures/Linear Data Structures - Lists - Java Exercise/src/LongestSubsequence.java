import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = numbers[0];
        int count = 1;

        int biggestCount = 1;
        int biggestNumber = num;

        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            if (currentNumber == num) {
                count++;
            } else {
                num = currentNumber;
                count = 1;
            }

            if (count > biggestCount) {
                biggestCount = count;
                biggestNumber = num;
            }
        }

        for (int i = 0; i < biggestCount; i++) {
            System.out.print(biggestNumber + " ");
        }
    }
}