import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        LinkedHashSet<Integer> setN = new LinkedHashSet<>();
        LinkedHashSet<Integer> setM = new LinkedHashSet<>();

        LinkedHashSet<Integer> repeatingElements = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            setN.add(Integer.parseInt(console.nextLine()));
        }

        for (int i = 0; i < m; i++) {
            setM.add(Integer.parseInt(console.nextLine()));
        }

        if (m >= n) {
            for (Integer number : setN) {
                if (setM.contains(number)) {
                    repeatingElements.add(number);
                }
            }
        } else {
            for (Integer number : setM) {
                if (setN.contains(number)) {
                    repeatingElements.add(number);
                }
            }
        }

        for (Integer number : repeatingElements) {
            System.out.print(number + " ");
        }
    }
}