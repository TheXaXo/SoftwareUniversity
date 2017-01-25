import java.util.ArrayDeque;
import java.util.Scanner;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        ArrayDeque<Integer> stockPrices = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stockPrices.push(Integer.parseInt(console.nextLine()));

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