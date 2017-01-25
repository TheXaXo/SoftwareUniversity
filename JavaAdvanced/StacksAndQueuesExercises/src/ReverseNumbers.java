import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] numbers = console.nextLine().split("\\s");

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}