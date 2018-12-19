import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumAndAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbersCount = 0;
        int numbersSum = 0;

        for (String numberStr : reader.readLine().split(" ")) {
            int number = Integer.parseInt(numberStr);

            numbersCount++;
            numbersSum += number;
        }

        System.out.printf("Sum=%d; Average=%.2f", numbersSum, ((double) numbersSum) / numbersCount);
    }
}