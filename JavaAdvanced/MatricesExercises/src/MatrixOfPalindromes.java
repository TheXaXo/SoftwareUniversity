import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = console.nextInt();
        int columns = console.nextInt();

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                char firstAndLastLetter = (char) (97 + row);
                char middleLetter = (char) (97 + row + col);

                matrix[row][col] =
                        Character.toString(firstAndLastLetter) + Character.toString(middleLetter) + Character.toString(firstAndLastLetter);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}