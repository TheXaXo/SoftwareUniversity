import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] kids = console.nextLine().split("\\s");
        int n = Integer.parseInt(console.nextLine());

        ArrayDeque<String> kidsCircle = new ArrayDeque<>();

        for (String kid : kids) {
            kidsCircle.add(kid);
        }

        int counter = 1;

        while (kidsCircle.size() > 1) {
            if (counter == n) {
                System.out.printf("Removed %s%n", kidsCircle.remove());

                counter = 1;
            } else {
                String kid = kidsCircle.remove();
                kidsCircle.add(kid);

                counter++;
            }
        }

        System.out.printf("Last is %s%n", kidsCircle.remove());
    }
}