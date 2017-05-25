import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeSet<String> elementsOrdered = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = console.nextLine().split(" ");

            for (String element : elements) {
                elementsOrdered.add(element);
            }
        }

        for (String element : elementsOrdered) {
            System.out.print(element + " ");
        }
    }
}