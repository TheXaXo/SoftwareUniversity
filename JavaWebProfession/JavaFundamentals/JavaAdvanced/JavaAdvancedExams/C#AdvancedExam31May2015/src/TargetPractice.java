import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        String string = reader.readLine();

        tokens = reader.readLine().split(" ");

        int shotRow = Integer.parseInt(tokens[0]);
        int shotCol = Integer.parseInt(tokens[1]);
        int shotRadius = Integer.parseInt(tokens[2]);

        char[][] stairs = new char[n][m];

        boolean startFromRight = true;
        int stringIndex = 0;

        for (int row = stairs.length - 1; row >= 0; row--) {
            if (startFromRight) {
                for (int col = stairs[row].length - 1; col >= 0; col--) {
                    stairs[row][col] = string.charAt(stringIndex);

                    stringIndex++;

                    if (stringIndex >= string.length()) {
                        stringIndex = 0;
                    }
                }

                startFromRight = false;
            } else {
                for (int col = 0; col < stairs[row].length; col++) {
                    stairs[row][col] = string.charAt(stringIndex);

                    stringIndex++;

                    if (stringIndex >= string.length()) {
                        stringIndex = 0;
                    }
                }

                startFromRight = true;
            }
        }

        for (int row = 0; row < stairs.length; row++) {
            for (int col = 0; col < stairs[row].length; col++) {
                if (Math.pow((col - shotCol), 2) + Math.pow((row - shotRow), 2) <= Math.pow(shotRadius, 2)) {
                    stairs[row][col] = ' ';
                }
            }
        }

        for (int col = 0; col < stairs[0].length; col++) {
            for (int row = stairs.length - 2; row >= 0; row--) {
                while (stairs[row][col] != ' ' && row != stairs.length - 1 && stairs[row + 1][col] == ' ') {
                    stairs[row + 1][col] = stairs[row][col];
                    stairs[row][col] = ' ';
                    row++;
                }
            }
        }

        for (int i = 0; i < stairs.length; i++) {
            for (int j = 0; j < stairs[i].length; j++) {
                System.out.print(stairs[i][j]);
            }

            System.out.println();
        }
    }
}