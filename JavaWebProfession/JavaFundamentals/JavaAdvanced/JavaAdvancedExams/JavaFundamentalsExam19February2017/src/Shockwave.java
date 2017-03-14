import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().trim().split("\\s+");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0;
            }
        }

        String command = reader.readLine();

        while (!command.equals("Here We Go")) {
            String[] split = command.trim().split("\\s+");

            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]);
            int y2 = Integer.parseInt(split[3]);

            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    matrix[j][i]++;
                }
            }

            command = reader.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}