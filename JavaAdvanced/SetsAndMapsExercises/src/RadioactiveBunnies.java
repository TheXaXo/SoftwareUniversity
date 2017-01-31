import java.util.Scanner;

public class RadioactiveBunnies {

    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        String[] split = console.nextLine().split(" ");
        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        boolean hasDied = false;

        char[][] field = new char[rows][columns];

        fillMatrix(field);

        char[] commands = console.nextLine().toCharArray();

        for (char command : commands) {
            int playerRowBefore = getPlayerRow(field);
            int playerColBefore = getPlayerCol(field);

            int playerRowAfter = playerRowBefore;
            int playerColAfter = playerColBefore;

            switch (command) {
                case 'U':
                    playerRowAfter--;
                    break;

                case 'D':
                    playerRowAfter++;
                    break;

                case 'L':
                    playerColAfter--;
                    break;

                case 'R':
                    playerColAfter++;
                    break;
            }

            field[playerRowBefore][playerColBefore] = '.';

            boolean hasEscaped = hasEscaped(field, playerRowAfter, playerColAfter);

            if (hasEscaped) {
                field[playerRowBefore][playerColBefore] = '.';
            } else if (field[playerRowAfter][playerColAfter] == 'B') {
                hasDied = true;
            }

            if (!hasDied && !hasEscaped) {
                field[playerRowAfter][playerColAfter] = 'P';
            }

            updateField(field);

            if (hasEscaped) {
                printField(field);
                System.out.printf("won: %d %d", playerRowBefore, playerColBefore);

                return;
            } else if (hasBeenEaten(field) || hasDied) {
                printField(field);
                System.out.printf("dead: %d %d", playerRowAfter, playerColAfter);

                return;
            }
        }
    }

    public static void fillMatrix(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            char[] rowElemens = console.nextLine().toCharArray();

            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = rowElemens[j];
            }
        }
    }

    public static int getPlayerRow(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'P') {
                    return i;
                }
            }
        }

        return 0;
    }

    public static int getPlayerCol(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'P') {
                    return j;
                }
            }
        }

        return 0;
    }

    public static boolean hasEscaped(char[][] field, int row, int col) {
        if (row < 0 || row >= field.length || col < 0 || col >= field[row].length) {
            return true;
        }

        return false;
    }


    public static void updateField(char[][] field) {
        boolean[][] fieldOriginalBunnies = new boolean[field.length][field[0].length];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 'B') {
                    fieldOriginalBunnies[i][j] = true;
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (fieldOriginalBunnies[i][j]) {
                    int topIndex = i - 1;
                    int bottomIndex = i + 1;
                    int leftIndex = j - 1;
                    int rightIndex = j + 1;

                    if (topIndex >= 0) {
                        field[topIndex][j] = 'B';
                    }
                    if (bottomIndex < field.length) {
                        field[bottomIndex][j] = 'B';
                    }
                    if (leftIndex >= 0) {
                        field[i][leftIndex] = 'B';
                    }
                    if (rightIndex < field[0].length) {
                        field[i][rightIndex] = 'B';
                    }
                }
            }
        }
    }

    public static boolean hasBeenEaten(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 'P') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}