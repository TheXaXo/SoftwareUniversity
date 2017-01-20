import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        Pattern p = Pattern.compile("Rotate\\(([0-9]+)\\)");
        Matcher m = p.matcher(command);

        if (!m.matches()) {
            return;
        }

        int degreesConverted = Integer.parseInt(m.group(1)) % 360;

        ArrayList<String> rows = new ArrayList<>();
        int longestWordCount = Integer.MIN_VALUE;

        command = console.nextLine();

        while (!command.equals("END")) {
            rows.add(command);

            if (command.length() > longestWordCount) {
                longestWordCount = command.length();
            }

            command = console.nextLine();
        }

        char[][] matrix = new char[rows.size()][longestWordCount];

        for (int row = 0; row < matrix.length; row++) {
            char[] rowElements = rows.get(row).toCharArray();

            for (int column = 0; column < matrix[row].length; column++) {
                if (column < rowElements.length) {
                    matrix[row][column] = rowElements[column];
                } else {
                    matrix[row][column] = ' ';
                }
            }
        }

        char[][] rotatedMatrix;

        int rowInRotated = 0;
        int colInRotated = 0;

        if (degreesConverted == 90) {
            rotatedMatrix = new char[matrix[0].length][matrix.length];

            for (int col = 0; col < matrix[0].length; col++) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    rotatedMatrix[rowInRotated][colInRotated] = matrix[row][col];
                    colInRotated++;
                }
                rowInRotated++;
                colInRotated = 0;
            }
        } else if (degreesConverted == 180) {
            rotatedMatrix = new char[matrix.length][matrix[0].length];

            for (int row = matrix.length - 1; row >= 0; row--) {
                for (int col = matrix[0].length - 1; col >= 0; col--) {
                    rotatedMatrix[rowInRotated][colInRotated] = matrix[row][col];
                    colInRotated++;
                }

                colInRotated = 0;
                rowInRotated++;
            }
        } else if (degreesConverted == 270){
            rotatedMatrix = new char[matrix[0].length][matrix.length];

            for (int col = matrix[0].length - 1; col >= 0; col--) {
                for (int row = 0; row < matrix.length; row++) {
                    rotatedMatrix[rowInRotated][colInRotated] = matrix[row][col];
                    colInRotated++;
                }

                rowInRotated++;
                colInRotated = 0;
            }
        } else {
            rotatedMatrix = matrix;
        }

        for (int row = 0; row < rotatedMatrix.length; row++) {
            for (int col = 0; col < rotatedMatrix[0].length; col++) {
                System.out.print(rotatedMatrix[row][col]);
            }

            System.out.println();
        }
    }
}