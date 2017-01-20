import java.util.ArrayList;
import java.util.Scanner;

public class PlusRemove {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> matrixStatus = new ArrayList<>();

        String command = console.nextLine();

        int currentRow = 0;

        while (!command.equals("END")) {
            char[] rowElements = command.toCharArray();

            matrix.add(new ArrayList<>());
            matrixStatus.add(new ArrayList<>());

            for (int i = 0; i < rowElements.length; i++) {
                matrix.get(currentRow).add(rowElements[i]);
                matrixStatus.get(currentRow).add(false);
            }

            currentRow++;
            command = console.nextLine();
        }

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 1; col < matrix.get(row).size(); col++) {
                if (row + 2 >= matrix.size() ||
                        col > matrix.get(row + 2).size() - 1 ||
                        col + 1 >= matrix.get(row + 1).size()) {
                    continue;
                }

                char top = Character.toLowerCase(matrix.get(row).get(col));
                char center = Character.toLowerCase(matrix.get(row + 1).get(col));
                char bottom = Character.toLowerCase(matrix.get(row + 2).get(col));

                char left = Character.toLowerCase(matrix.get(row + 1).get(col - 1));
                char right = Character.toLowerCase(matrix.get(row + 1).get(col + 1));

                if (top == center && center == bottom && bottom == left && left == right) {
                    matrixStatus.get(row).set(col, true);
                    matrixStatus.get(row + 1).set(col, true);
                    matrixStatus.get(row + 2).set(col, true);

                    matrixStatus.get(row + 1).set(col - 1, true);
                    matrixStatus.get(row + 1).set(col + 1, true);
                }
            }
        }

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                if (!matrixStatus.get(row).get(col)) {
                    System.out.print(matrix.get(row).get(col));
                }
            }

            System.out.println();
        }
    }
}