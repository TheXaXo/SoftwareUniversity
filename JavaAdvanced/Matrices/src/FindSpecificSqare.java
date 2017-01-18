import java.util.Scanner;

public class FindSpecificSqare {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split(", ");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowColumns = console.nextLine().split(", ");

            for (int column = 0; column < columns; column++) {
                matrix[row][column] = Integer.parseInt(rowColumns[column]);
            }
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[][] square = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int column = 0; column < columns - 1; column++) {
                sum = matrix[row][column] + matrix[row][column + 1] + matrix[row + 1][column] + matrix[row + 1][column + 1];

                int[] squareElements = new int[]{matrix[row][column], matrix[row][column + 1], matrix[row + 1][column], matrix[row + 1][column + 1]};

                int count = 0;

                if (sum > maxSum) {
                    maxSum = sum;
                    sum = 0;

                    for (int squareRow = 0; squareRow < 2; squareRow++) {
                        for (int squareColumn = 0; squareColumn < 2; squareColumn++) {
                            square[squareRow][squareColumn] = squareElements[count];
                            count++;
                        }
                    }
                }
            }
        }

        for (int row = 0; row < square.length; row++) {
            for (int column = 0; column < square[0].length; column++) {
                System.out.print(square[row][column] + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }
}