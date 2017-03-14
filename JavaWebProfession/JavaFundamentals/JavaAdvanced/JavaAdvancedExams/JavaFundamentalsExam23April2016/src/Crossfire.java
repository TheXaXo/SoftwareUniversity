import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        String[] tokens = reader.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int number = 1;

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());

            for (int j = 0; j < m; j++) {
                matrix.get(i).add(number);
                number++;
            }
        }

        String command = reader.readLine();

        while (!command.equals("Nuke it from orbit")) {
            tokens = command.split(" ");

            long impactRow = Long.parseLong(tokens[0]);
            long impactCol = Long.parseLong(tokens[1]);
            long impactRadius = Long.parseLong(tokens[2]);

            for (long row = impactRow - impactRadius; row <= impactRow + impactRadius; row++) {
                if (row >= 0 && row < matrix.size() && impactCol >= 0 && matrix.get((int) row).size() > impactCol) {
                    matrix.get((int) row).set((int) impactCol, 0);
                }
            }

            for (long col = impactCol + impactRadius; col >= impactCol - impactRadius; col--) {
                if (impactRow >= 0 && impactRow < matrix.size() && col >= 0 && matrix.get((int) impactRow).size() > col) {
                    matrix.get((int) impactRow).set((int) col, 0);
                }
            }

            command = reader.readLine();
        }

        for (int row = 0; row < matrix.size(); row++) {
            if (matrix.get(row).stream().mapToInt(a -> a).sum() == 0) {
                continue;
            }
            for (int col = 0; col < matrix.get(row).size(); col++) {
                if (matrix.get(row).get(col) == 0) {
                    continue;
                }
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }
}