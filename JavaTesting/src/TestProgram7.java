import java.util.*;
import java.util.stream.Collectors;

public class TestProgram7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .filter(a -> Math.sqrt(a) % 1 == 0)
                .sorted((a, b) -> Integer.compare(b, a))
                .collect(Collectors.toCollection(ArrayList::new));

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}