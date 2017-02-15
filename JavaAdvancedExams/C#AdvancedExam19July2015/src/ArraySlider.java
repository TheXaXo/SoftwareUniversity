import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArraySlider {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().trim().split("\\s+");

        ArrayList<Long> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Long.parseLong(token));
        }

        String command = reader.readLine();

        long lastIndex = 0;

        while (!command.equals("stop")) {
            tokens = command.trim().split("\\s+");

            long offset = Integer.parseInt(tokens[0]);
            char type = tokens[1].charAt(0);
            long number = Integer.parseInt(tokens[2]);

            if (offset > 0) {
                lastIndex += offset;

                if (lastIndex >= numbers.size()) {
                    lastIndex %= numbers.size();
                }
            } else {
                lastIndex -= offset;

                if (lastIndex < 0) {
                    lastIndex %= numbers.size();
                }
            }

            switch (type) {
                case '+':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) + number);
                    break;

                case '-':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) - number);
                    break;

                case '*':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) * number);
                    break;

                case '/':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) / number);
                    break;

                case '^':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) ^ number);
                    break;

                case '&':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) & number);
                    break;

                case '|':
                    numbers.set((int) lastIndex, numbers.get((int) lastIndex) | number);
                    break;
            }

            if (numbers.get((int) lastIndex) < 0) {
                numbers.set((int) lastIndex, 0L);
            }

            command = reader.readLine();
        }

        System.out.println(numbers);
    }
}