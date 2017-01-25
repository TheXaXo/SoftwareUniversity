import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        ArrayDeque<Character> chars = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            chars.push(c);
        }

        boolean isPalindrome = true;

        while (chars.size() > 1) {
            if (chars.poll() != chars.pollLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}