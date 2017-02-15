import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunkerBuster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] field = new int[n][m];

        for (int row = 0; row < n; row++) {
            String[] rowElements = reader.readLine().split(" ");

            for (int col = 0; col < m; col++) {
                field[row][col] = Integer.parseInt(rowElements[col]);
            }
        }

        String command = reader.readLine();

        while (!command.equals("cease fire!")) {
            tokens = command.split(" ");

            int impactRow = Integer.parseInt(tokens[0]);
            int impactCol = Integer.parseInt(tokens[1]);
            int impactPower = tokens[2].charAt(0);

            field[impactRow][impactCol] -= impactPower;

            impactPower = (int) Math.ceil(impactPower / 2d);

            for (int i = impactRow - 1; i <= impactRow + 1; i++) {
                for (int j = impactCol - 1; j <= impactCol + 1; j++) {
                    if (i >= 0 && i < field.length && j >= 0 && j < field[n - 1].length && !(i == impactRow && j == impactCol)) {
                        field[i][j] -= impactPower;
                    }
                }
            }

            command = reader.readLine();
        }

        int destroyedBunkers = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] <= 0) {
                    destroyedBunkers++;
                }
            }
        }

        double percentage = (double) destroyedBunkers / (n * m) * 100;

        System.out.println("Destroyed bunkers: " + destroyedBunkers);
        System.out.printf("Damage done: %.1f %%%n", percentage);
    }
}