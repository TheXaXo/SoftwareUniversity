import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CommandInterpreter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = reader.readLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "reverse":
                    int index = Integer.parseInt(tokens[2]);
                    int count = Integer.parseInt(tokens[4]);

                    long desiredIndex = (long) index + count - 1;

                    if (index < 0 || index >= numbers.size() || count < 0 || desiredIndex + 1 < 0 || desiredIndex >= numbers.size()) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    ArrayList<String> reversedArray = new ArrayList<>();

                    for (int i = (int) desiredIndex; i >= index; i--) {
                        reversedArray.add(numbers.get(i));
                    }

                    int m = 0;

                    for (int i = index; i <= desiredIndex; i++) {
                        numbers.set(i, reversedArray.get(m));
                        m++;
                    }

                    break;

                case "sort":
                    index = Integer.parseInt(tokens[2]);
                    count = Integer.parseInt(tokens[4]);

                    desiredIndex = (long) index + count - 1;

                    if (index < 0 || index >= numbers.size() || count < 0 || desiredIndex + 1 < 0 || desiredIndex >= numbers.size()) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    ArrayList<String> sortedArray = new ArrayList<>();

                    for (int i = index; i <= desiredIndex; i++) {
                        sortedArray.add(numbers.get(i));
                    }

                    Collections.sort(sortedArray);

                    m = 0;

                    for (int i = index; i <= desiredIndex; i++) {
                        numbers.set(i, sortedArray.get(m));
                        m++;
                    }

                    break;

                case "rollLeft":
                    count = Integer.parseInt(tokens[1]);

                    if (count < 0) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    for (int i = 0; i < count % numbers.size(); i++) {
                        String firstElement = numbers.get(0);

                        for (int elementIndex = 0; elementIndex < numbers.size() - 1; elementIndex++) {
                            numbers.set(elementIndex, numbers.get(elementIndex + 1));
                        }

                        numbers.set(numbers.size() - 1, firstElement);
                    }

                    break;

                case "rollRight":
                    count = Integer.parseInt(tokens[1]);

                    if (count < 0) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    for (int i = 0; i < count % numbers.size(); i++) {
                        String lastElement = numbers.get(numbers.size() - 1);

                        for (int elementIndex = numbers.size() - 1; elementIndex > 0; elementIndex--) {
                            numbers.set(elementIndex, numbers.get(elementIndex - 1));
                        }

                        numbers.set(0, lastElement);
                    }

                    break;

            }

            command = reader.readLine();
        }

        System.out.println(numbers);
    }
}