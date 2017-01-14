import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(a -> Integer.parseInt(a))
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        String[] command = console.nextLine().split("\\s");

        int bombNumber = Integer.parseInt(command[0]);
        int power = Integer.parseInt(command[1]);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber) {
                int startIndex = i - power;
                int endIndex = i + power;

                if (startIndex < 0) {
                    startIndex = 0;
                }

                if (endIndex >= numbers.size()) {
                    endIndex = numbers.size() - 1;
                }

                numbers.subList(startIndex, endIndex + 1).clear();
                i = 0;
            }
        }

        System.out.println(numbers.stream().mapToInt(a -> a).sum());
    }
}