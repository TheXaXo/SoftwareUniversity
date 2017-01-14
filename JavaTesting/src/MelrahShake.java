import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder input = new StringBuilder(console.nextLine());
        StringBuilder pattern = new StringBuilder(console.nextLine());

        while (input.indexOf(pattern.toString()) != input.lastIndexOf(pattern.toString()) &&
                pattern.length() > 0) {
            input.delete(input.indexOf(pattern.toString()), input.indexOf(pattern.toString()) + pattern.length());
            input.delete(input.lastIndexOf(pattern.toString()), input.lastIndexOf(pattern.toString()) + pattern.length());

            pattern.delete(pattern.length() / 2, pattern.length() / 2 + 1);

            System.out.println("Shaked it.");
        }

        System.out.println("No shake.");
        System.out.println(input);
    }
}