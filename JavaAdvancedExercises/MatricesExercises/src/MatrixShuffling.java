import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split("\\s");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowElements = console.nextLine().split("\\s");

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = rowElements[col];
            }
        }

        String command = console.nextLine();

        Pattern pattern = Pattern.compile("swap ([0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)");

        while (!command.equals("END")) {
            Matcher matcher = pattern.matcher(command);

            if (!matcher.matches()) {
                System.out.println("Invalid input!");
                command = console.nextLine();

                continue;
            }

            int row1 = Integer.parseInt(matcher.group(1));
            int col1 = Integer.parseInt(matcher.group(2));

            int row2 = Integer.parseInt(matcher.group(3));
            int col2 = Integer.parseInt(matcher.group(4));

            if (row1 < 0 || row1 >= matrix.length || row2 < 0 || row2 >= matrix.length ||
                    col1 < 0 || col1 >= matrix[row1].length || col2 < 0 || col2 >= matrix[row1].length) {
                System.out.println("Invalid input!");
                command = console.nextLine();

                continue;
            }

            String temp = matrix[row1][col1];

            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    System.out.print(matrix[row][col] + " ");
                }

                System.out.println();
            }

            command = console.nextLine();
        }
    }
}