import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        double[][] matrix = new double[n][m];
        tokens = reader.readLine().split(" ");

        double lukankaPrice = Double.parseDouble(tokens[0]);
        double rakiaPrice = Double.parseDouble(tokens[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!(i == 0 && j == 0)) {
                    if (i % 2 == 0) {
                        matrix[i][j] = ((i + 1) * (j + 1)) * lukankaPrice;
                    } else {
                        matrix[i][j] = ((i + 1) * (j + 1)) * rakiaPrice;
                    }
                }
            }
        }

        String command = reader.readLine();

        BigDecimal dailyEarnings = new BigDecimal(0);
        int customersCount = 0;

        while (!command.equals("Royal Close")) {
            customersCount++;

            tokens = command.split(" ");

            int row = Integer.parseInt(tokens[0]);
            int column = Integer.parseInt(tokens[1]);

            if (row < column) {
                for (int currentRow = row; currentRow >= 0; currentRow--) {
                    dailyEarnings = dailyEarnings.add(new BigDecimal(matrix[currentRow][column]));
                }

                for (int currentCol = column - 1; currentCol >= 0; currentCol--) {
                    dailyEarnings = dailyEarnings.add(new BigDecimal(matrix[0][currentCol]));
                }
            } else {
                for (int currentCol = column; currentCol >= 0; currentCol--) {
                    dailyEarnings = dailyEarnings.add(new BigDecimal(matrix[row][currentCol]));
                }

                for (int currentRow = row - 1; currentRow >= 0; currentRow--) {
                    dailyEarnings = dailyEarnings.add(new BigDecimal(matrix[currentRow][0]));
                }
            }

            command = reader.readLine();
        }

        System.out.printf("%.6f%n", dailyEarnings);
        System.out.println(customersCount);
    }
}