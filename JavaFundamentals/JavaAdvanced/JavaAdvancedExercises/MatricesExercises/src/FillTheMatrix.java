import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split(", ");

        int n = Integer.parseInt(split[0]);
        String pattern = split[1];

        int[][] matrix = new int[n][n];

        int number = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        } else {
            for (int col = 0; col < n; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = number;
                        number++;
                    }
                } else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][col] = number;
                        number++;
                    }
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}