import java.util.Scanner;

public class CollectTheCoins {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char[][] matrix = new char[4][];

        for (int row = 0; row < matrix.length; row++) {
            char[] rowElements = console.nextLine().toCharArray();

            matrix[row] = new char[rowElements.length];

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rowElements[col];
            }
        }

        char[] commands = console.nextLine().toCharArray();

        int coinsCollected = 0;
        int wallsHit = 0;

        int currentRow = 0;
        int currentCol = 0;

        for (char command : commands) {
            int wantedRow = currentRow;
            int wantedCol = currentCol;

            if (command == 'V') {
                wantedRow++;
            } else if (command == '^') {
                wantedRow--;
            } else if (command == '>') {
                wantedCol++;
            } else if (command == '<') {
                wantedCol--;
            }

            if (wantedRow < 0 || wantedRow >= matrix.length || wantedCol < 0 || wantedCol >= matrix[wantedRow].length) {
                wallsHit++;
            } else {
                currentRow = wantedRow;
                currentCol = wantedCol;

                if (matrix[currentRow][currentCol] == '$') {
                    coinsCollected++;
                }
            }
        }

        System.out.printf("Coins = %d%nWalls = %d", coinsCollected, wallsHit);
    }
}