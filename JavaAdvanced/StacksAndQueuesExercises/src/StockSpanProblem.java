import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class StockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stockPrices = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stockPrices.push(Integer.parseInt(reader.readLine()));

            ArrayDeque<Integer> numbersToCheck = stockPrices.clone();

            int count = 0;

            while (!numbersToCheck.isEmpty() && numbersToCheck.peek() <= stockPrices.peek()) {
                count++;
                numbersToCheck.pop();
            }

            System.out.println(count);
        }
    }
}