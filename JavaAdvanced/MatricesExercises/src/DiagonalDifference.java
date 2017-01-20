import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            String[] rowElements = console.nextLine().split("\\s");

            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(rowElements[col]);
            }
        }
        int primaryDiagonalSum = 0;

        int secondaryDiagonalElement = n - 1;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < n; row++) {
            primaryDiagonalSum += matrix[row][row];
            secondaryDiagonalSum += matrix[row][secondaryDiagonalElement];

            secondaryDiagonalElement--;
        }

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}