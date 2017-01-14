import java.util.Arrays;
import java.util.Scanner;

public class Ladybugs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int fieldSize = Integer.parseInt(console.nextLine());
        int[] ladybugsIndexes = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = console.nextLine();

        int[] field = new int[fieldSize];

        for (int index : ladybugsIndexes) {
            if (index < 0 || index >= fieldSize) {
                continue;
            }

            field[index] = 1;
        }

        while (!command.equals("end")) {
            String[] split = command.split("\\s");

            int index = Integer.parseInt(split[0]);
            String direction = split[1];
            int flyLength = Integer.parseInt(split[2]);

            int desiredLocation;
            boolean isOutOfField = false;

            if (direction.equals("left")) {
                desiredLocation = index - flyLength;
            } else {
                desiredLocation = index + flyLength;
            }

            if (index < 0 || index >= fieldSize || field[index] == 0) {
                command = console.nextLine();
                continue;
            }

            field[index] = 0;

            if (desiredLocation < 0 || desiredLocation >= fieldSize) {
                command = console.nextLine();
                continue;
            }

            while (field[desiredLocation] == 1) {
                if (direction.equals("left")) {
                    desiredLocation -= flyLength;
                } else {
                    desiredLocation += flyLength;
                }

                if (desiredLocation < 0 || desiredLocation >= fieldSize) {
                    isOutOfField = true;
                    break;
                }
            }

            if (!isOutOfField) {
                field[desiredLocation] = 1;
            }

            command = console.nextLine();
        }

        for (int index : field) {
            System.out.printf("%d ", index);
        }
    }
}