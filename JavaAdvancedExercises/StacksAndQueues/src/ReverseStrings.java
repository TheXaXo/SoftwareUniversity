import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String word = console.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}