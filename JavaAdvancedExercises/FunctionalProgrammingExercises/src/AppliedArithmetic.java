import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = reader.readLine();

        BiConsumer<int[], String> arithmeticFunc = (allNumbers, givenCommand) -> {
            switch (givenCommand) {
                case "add":
                    for (int i = 0; i < allNumbers.length; i++) {
                        allNumbers[i] += 1;
                    }
                    break;

                case "multiply":
                    for (int i = 0; i < allNumbers.length; i++) {
                        allNumbers[i] *= 2;
                    }
                    break;

                case "subtract":
                    for (int i = 0; i < allNumbers.length; i++) {
                        allNumbers[i] -= 1;
                    }
                    break;

                case "print":
                    for (int number : numbers) {
                        System.out.print(number + " ");
                    }
                    System.out.println();
                    break;
            }
        };

        while (!command.equals("end")) {
            arithmeticFunc.accept(numbers, command);

            command = reader.readLine();
        }
    }
}