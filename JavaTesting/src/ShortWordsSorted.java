import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShortWordsSorted {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] words = Arrays.stream(console.nextLine().split("[.,:;()\\[\\]\"'\\\\/!?\\s]"))
                .map(String::toLowerCase)
                .distinct()
                .filter(a -> a.length() < 5 && a.length() > 0)
                .sorted(Comparator.comparing(a -> a))
                .toArray(String[]::new);

        System.out.println(String.join(", ", words));
    }
}