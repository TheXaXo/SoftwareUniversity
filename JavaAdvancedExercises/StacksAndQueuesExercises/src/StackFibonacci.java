import java.util.ArrayDeque;
import java.util.Scanner;

public class StackFibonacci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = console.nextInt();

        ArrayDeque<Long> numbers = new ArrayDeque<>();

        numbers.push(1L);
        numbers.push(1L);

        long numberToPrint = 1;

        for (int i = 1; i < n; i++) {
            long firstNumber = numbers.pop();
            long secondNumber = numbers.pop();

            long thirdNumber = firstNumber + secondNumber;

            numbers.push(secondNumber);
            numbers.push(firstNumber);
            numbers.push(thirdNumber);

            numberToPrint = numbers.peek();
        }

        System.out.println(numberToPrint);
    }
}