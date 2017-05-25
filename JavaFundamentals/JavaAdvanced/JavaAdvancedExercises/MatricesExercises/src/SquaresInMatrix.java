import java.util.Scanner;

public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split("\\s");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        char[][] matrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowElements = console.nextLine().split("\\s");

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = rowElements[col].toCharArray()[0];
            }
        }

        int count = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col =  0; col < columns - 1; col++) {
                if (matrix[row][col] == matrix[row][col + 1] &&
                        matrix[row][col + 1] == matrix[row + 1][col] &&
                        matrix[row + 1][col] == matrix[row + 1][col + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}