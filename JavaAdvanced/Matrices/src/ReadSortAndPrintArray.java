import java.util.Arrays;
import java.util.Scanner;

public class ReadSortAndPrintArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = Integer.parseInt(console.nextLine());

        String[] elements = new String[count];

        for (int i = 0; i < count; i++) {
            elements[i] = console.nextLine();
        }

        Arrays.sort(elements);

        for (String element : elements) {
            System.out.println(element);
        }
    }
}