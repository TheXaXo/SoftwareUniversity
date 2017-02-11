import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Infernolll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        HashMap<Integer, Boolean> numberStatus = new HashMap<>();

        for (int number : numbers) {
            numberStatus.put(number, false);
        }

        String command = reader.readLine();

        while (!command.equals("Forge")) {
            String[] commandArgs = command.split(";");

            String commandType = commandArgs[0];
            String filter = commandArgs[1];
            String parameter = commandArgs[2];

            switch (commandType) {
                case "Exclude":
                    for (int number : numbers) {
                        int indexOfLeft = numbers.indexOf(number) - 1;
                        int indexOfRight = numbers.indexOf(number) + 1;

                        int leftNumber = 0;
                        int rightNumber = 0;

                        if (indexOfLeft >= 0) {
                            leftNumber = numbers.get(indexOfLeft);
                        }

                        if (indexOfRight < numbers.size()) {
                            rightNumber = numbers.get(indexOfRight);
                        }

                        if (filter.equals("Sum Left")) {
                            if (number + leftNumber == Integer.parseInt(parameter)) {
                                numberStatus.put(number, true);
                            }
                        } else if (filter.equals("Sum Right")) {
                            if (number + rightNumber == Integer.parseInt(parameter)) {
                                numberStatus.put(number, true);
                            }
                        } else if (filter.equals("Sum Left Right")) {
                            if (number + leftNumber + rightNumber == Integer.parseInt(parameter)) {
                                numberStatus.put(number, true);
                            }
                        }
                    }

                    break;

                case "Reverse":
                    for (int number : numbers) {
                        int indexOfLeft = numbers.indexOf(number) - 1;
                        int indexOfRight = numbers.indexOf(number) + 1;

                        int leftNumber = 0;
                        int rightNumber = 0;

                        if (indexOfLeft >= 0) {
                            leftNumber = numbers.get(indexOfLeft);
                        }

                        if (indexOfRight < numbers.size()) {
                            rightNumber = numbers.get(indexOfRight);
                        }

                        if (filter.equals("Sum Left") && numberStatus.get(number)) {
                            if (number + leftNumber == Integer.parseInt(parameter)) {
                                numberStatus.put(number, false);
                            }
                        } else if (filter.equals("Sum Right") && numberStatus.get(number)) {
                            if (number + rightNumber == Integer.parseInt(parameter)) {
                                numberStatus.put(number, false);
                            }
                        } else if (filter.equals("Sum Left Right") && numberStatus.get(number)) {
                            if (number + leftNumber + rightNumber == Integer.parseInt(parameter)) {
                                numberStatus.put(number, false);
                            }
                        }
                    }

                    break;
            }

            command = reader.readLine();
        }

        for (int number : numbers) {
            if (!numberStatus.get(number)) {
                System.out.print(number + " ");
            }
        }
    }
}