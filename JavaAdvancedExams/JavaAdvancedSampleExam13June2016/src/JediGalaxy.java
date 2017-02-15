import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[n][m];

        int number = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = number;
                number++;
            }
        }

        String command = reader.readLine();

        boolean[][] isDestroyed = new boolean[n][m];

        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            String[] commandTokens = command.split(" ");

            int ivoRow = Integer.parseInt(commandTokens[0]);
            int ivoCol = Integer.parseInt(commandTokens[1]);

            command = reader.readLine();
            commandTokens = command.split(" ");

            int evilRow = Integer.parseInt(commandTokens[0]);
            int evilCol = Integer.parseInt(commandTokens[1]);

            for (int row = evilRow; row >= 0; row--) {
                if (row < 0 || row >= n || evilCol < 0 || evilCol >= m) {
                    evilCol--;
                    continue;
                }

                isDestroyed[row][evilCol] = true;

                evilCol--;
            }

            for (int row = ivoRow; row >= 0; row--) {
                if (row < 0 || row >= n || ivoCol < 0 || ivoCol >= m) {
                    ivoCol++;
                    continue;
                }

                if (!isDestroyed[row][ivoCol]) {
                    sum += (long) matrix[row][ivoCol];
                }

                ivoCol++;
            }

            command = reader.readLine();
        }

        System.out.println(sum);
    }
}