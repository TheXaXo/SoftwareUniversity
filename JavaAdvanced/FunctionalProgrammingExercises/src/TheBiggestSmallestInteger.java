import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TheBiggestSmallestInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        BiFunction<ArrayList<Integer>, String, Integer> findBiggestNum = (allNumbers, type) -> {
            int biggestNumber = Integer.MIN_VALUE;

            if (type.equals("even")) {
                for (int number : allNumbers) {
                    if (number % 2 == 0 && number >= biggestNumber) {
                        biggestNumber = number;
                    }
                }
            } else {
                for (int number : allNumbers) {
                    if (number % 2 != 0 && number >= biggestNumber) {
                        biggestNumber = number;
                    }
                }
            }

            return biggestNumber;
        };

        BiFunction<ArrayList<Integer>, String, Integer> findSmallestNum = (allNumbers, type) -> {
            int smallestNumber = Integer.MAX_VALUE;

            if (type.equals("even")) {
                for (int number : allNumbers) {
                    if (number % 2 == 0 && number <= smallestNumber) {
                        smallestNumber = number;
                    }
                }
            } else {
                for (int number : allNumbers) {
                    if (number % 2 != 0 && number <= smallestNumber) {
                        smallestNumber = number;
                    }
                }
            }


            return smallestNumber;
        };

        String command = reader.readLine();

        switch (command) {
            case "minEven":
                System.out.println(findSmallestNum.apply(numbers, "even"));

                break;

            case "minOdd":
                System.out.println(findSmallestNum.apply(numbers, "odd"));

                break;

            case "maxEven":
                System.out.println(findBiggestNum.apply(numbers, "even"));

                break;

            case "maxOdd":
                System.out.println(findBiggestNum.apply(numbers, "odd"));

                break;
        }
    }
}
