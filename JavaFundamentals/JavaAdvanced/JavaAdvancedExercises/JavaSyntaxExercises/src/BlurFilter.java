import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long blurAmount = Long.parseLong(console.nextLine());

        String[] split = console.nextLine().split("\\s");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        long[][] matrix = new long[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowElements = console.nextLine().split("\\s");

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Long.parseLong(rowElements[col]);
            }
        }

        split = console.nextLine().split("\\s");

        int blurRowStart = Integer.parseInt(split[0]) - 1;
        int blurColStart = Integer.parseInt(split[1]) - 1;

        int blurRowEnd = blurRowStart + 2;
        int blurColEnd = blurColStart + 2;

        if (blurRowStart < 0) {
            blurRowStart = 0;
        }

        if (blurColStart < 0) {
            blurColStart = 0;
        }

        if (blurColEnd >= matrix[0].length) {
            blurColEnd = matrix[0].length - 1;
        }

        if (blurRowEnd >= matrix.length) {
            blurRowEnd = matrix.length - 1;
        }

        for (int row = blurRowStart; row <= blurRowEnd; row++) {
            for (int col = blurColStart; col <= blurColEnd; col++) {
                matrix[row][col] = matrix[row][col] + blurAmount;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}