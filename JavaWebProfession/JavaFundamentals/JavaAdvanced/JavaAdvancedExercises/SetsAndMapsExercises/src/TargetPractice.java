import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split(" ");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        char[][] stairs = new char[rows][columns];

        String snake = console.nextLine();

        int reachedIndex = 0;

        boolean startFromBack = true;

        for (int row = stairs.length - 1; row >= 0; row--) {
            if (startFromBack) {
                for (int column = stairs[row].length - 1; column >= 0; column--) {
                    stairs[row][column] = snake.charAt(reachedIndex);
                    reachedIndex++;

                    if (reachedIndex >= snake.length()) {
                        reachedIndex = 0;
                    }
                }

                startFromBack = false;
            } else {
                for (int column = 0; column < stairs[row].length; column++) {
                    stairs[row][column] = snake.charAt(reachedIndex);
                    reachedIndex++;

                    if (reachedIndex >= snake.length()) {
                        reachedIndex = 0;
                    }
                }

                startFromBack = true;
            }
        }

        split = console.nextLine().split(" ");

        int impactRow = Integer.parseInt(split[0]);
        int impactCol = Integer.parseInt(split[1]);
        int impactRadius = Integer.parseInt(split[2]);

        for (int row = 0; row < stairs.length; row++) {
            for (int col = 0; col < stairs[row].length; col++) {
                if (((row - impactRow) * (row - impactRow)) + ((col - impactCol) * (col - impactCol)) <= impactRadius * impactRadius) {
                    stairs[row][col] = ' ';
                }
            }
        }

        for (int col = 0; col < stairs[0].length; col++) {
            for (int row = stairs.length - 2; row >= 0; row--) {
                int belowRow = row + 1;
                int itemRow = row;

                while (belowRow < stairs.length && stairs[belowRow][col] == ' ') {
                    stairs[belowRow][col] = stairs[itemRow][col];
                    stairs[itemRow][col] = ' ';

                    itemRow++;
                    belowRow++;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(stairs[row][col]);
            }

            System.out.println();
        }
    }
}