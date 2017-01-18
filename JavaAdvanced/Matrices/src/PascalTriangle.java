import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = Integer.parseInt(console.nextLine());

        long[][] triangle = new long[count][];

        for (int row = 0; row < count; row++) {
            triangle[row] = new long[row + 1];
        }

        triangle[0][0] = 1;

        for (int row = 1; row < triangle.length; row++) {
            for (int column = 0; column < triangle[row].length; column++) {
                long topNumber = 0;
                long topLeftNumber = 0;

                if (triangle[row - 1].length > column) {
                    topNumber = triangle[row - 1][column];
                }

                if (column != 0) {
                    topLeftNumber = triangle[row - 1][column - 1];
                }

                triangle[row][column] = topNumber + topLeftNumber;
            }
        }

        for (int row = 0; row < triangle.length; row++) {
            for (int column = 0; column < triangle[row].length; column++) {
                System.out.print(triangle[row][column] + " ");
            }
            System.out.println();
        }
    }
}