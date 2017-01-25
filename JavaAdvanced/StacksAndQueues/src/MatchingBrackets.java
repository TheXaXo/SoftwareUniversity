import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String expression = console.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.toCharArray()[i] == '(') {
                indexes.push(i);
            } else if (expression.toCharArray()[i] == ')') {
                int lastIndex = i;
                int firstIndex = indexes.pop();

                System.out.println(expression.substring(firstIndex, lastIndex + 1));
            }
        }
    }
}