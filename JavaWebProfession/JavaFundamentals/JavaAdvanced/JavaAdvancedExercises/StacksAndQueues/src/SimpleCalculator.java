import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] elements = console.nextLine().split("\\s");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String element : elements) {
            stack.push(element);
        }

        int result = 0;

        while (!stack.isEmpty()) {
            int number = Integer.parseInt(stack.pop());
            String operator = "+";

            if (!stack.isEmpty()) {
                operator = stack.pop();
            }

            if (operator.equals("+")) {
                result += number;
            } else {
                result -= number;
            }
        }

        System.out.println(result);
    }
}