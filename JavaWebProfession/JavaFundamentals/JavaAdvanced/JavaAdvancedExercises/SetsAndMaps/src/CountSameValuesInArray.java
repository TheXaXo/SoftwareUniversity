import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        HashMap<String, Integer> numberCount = new HashMap<>();

        String[] split = console.nextLine().split(" ");

        for (String number : split) {
            if (!numberCount.containsKey(number)) {
                numberCount.put(number, 1);
            } else {
                numberCount.put(number, numberCount.get(number) + 1);
            }
        }

        for (String number : numberCount.keySet()) {
            System.out.printf("%s - %d times%n", number, numberCount.get(number));
        }
    }
}