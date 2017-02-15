import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NatureProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] garden = new int[n][m];

        String command = reader.readLine();

        while (!command.equals("Bloom Bloom Plow")) {
            tokens = command.split(" ");
            n = Integer.parseInt(tokens[0]);
            m = Integer.parseInt(tokens[1]);

            garden[n][m]++;

            for (int col = 0; col < garden[n].length; col++) {
                if (col == m) {
                    continue;
                }

                garden[n][col]++;
            }

            for (int row = 0; row < garden.length; row++) {
                if (row == n) {
                    continue;
                }

                garden[row][m]++;
            }

            command = reader.readLine();
        }

        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }

            System.out.println();
        }
    }
}