import java.util.Scanner;

public class SumAllElementsOfMatrix {
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

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                sum += matrix[row][column];
            }
        }

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}