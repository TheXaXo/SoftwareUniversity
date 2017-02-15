import java.util.ArrayList;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] splitArgs = console.nextLine().split(" ");

        int rows = Integer.parseInt(splitArgs[0]);
        int columns = Integer.parseInt(splitArgs[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int number = 1;

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < columns; j++) {
                matrix.get(i).add(number);

                number++;
            }
        }

        String command = console.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            splitArgs = command.split(" ");

            int impactRow = Integer.parseInt(splitArgs[0]);
            int impactCol = Integer.parseInt(splitArgs[1]);
            long impactRadius = Long.parseLong(splitArgs[2]);

            long impactTop = impactRow - impactRadius;
            long impactBottom = impactRow + impactRadius;
            long impactLeft = impactCol - impactRadius;
            long impactRight = impactCol + impactRadius;

            for (long row = impactTop; row <= impactBottom; row++) {
                if (row >= 0 && row < matrix.size()) {
                    if (impactCol >= 0 && impactCol < matrix.get((int) row).size()) {
                        matrix.get((int) row).set(impactCol, 0);
                    }
                }
            }

            if (impactRow >= 0 && impactRow < matrix.size()) {
                for (long col = impactLeft; col <= impactRight; col++) {
                    if (col >= 0 && col < matrix.get(impactRow).size()) {
                        matrix.get(impactRow).set((int) col, 0);
                    }
                }
            }

            updateMatrix(matrix);

            command = console.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }

    public static void updateMatrix(ArrayList<ArrayList<Integer>> matrix) {
        boolean wholeRowIsEmpty = false;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 0) {
                    if (matrix.get(i).stream().mapToInt(a -> a).sum() == 0) {
                        wholeRowIsEmpty = true;
                    }

                    if (wholeRowIsEmpty) {
                        matrix.remove(i);
                        break;
                    }

                    matrix.get(i).remove(j);

                    j = 0;
                }
            }

            if (wholeRowIsEmpty) {
                wholeRowIsEmpty = false;
            }
        }
    }
}