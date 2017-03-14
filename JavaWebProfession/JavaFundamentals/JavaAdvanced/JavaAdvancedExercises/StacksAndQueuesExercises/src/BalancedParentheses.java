import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                openingBrackets.push(c);
            } else {
                if (openingBrackets.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                char lastBracket = openingBrackets.pop();

                if (!(lastBracket == '{' && c == '}'
                        || lastBracket == '[' && c == ']'
                        || lastBracket == '(' && c == ')')) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}