import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split("\\s");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowElements = console.nextLine().split("\\s");

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(rowElements[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < columns - 2; col++) {
                int sum = 0;

                for (int innerRow = row; innerRow < row + 3; innerRow++) {
                    for (int innerCol = col; innerCol < col + 3; innerCol++) {
                        sum += matrix[innerRow][innerCol];

                        if (sum > maxSum) {
                            maxSum = sum;
                            maxRow = row;
                            maxCol = col;
                        }
                    }
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);

        for (int row = maxRow; row < maxRow + 3; row++) {
            for (int col = maxCol; col < maxCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}