import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class DistanceInLabyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int startRow = 0;
        int startCol = 0;

        String[][] labyrinth = new String[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] items = reader.readLine().split("");

            for (int j = 0; j < items.length; j++) {
                labyrinth[i][j] = items[j];

                if (items[j].equals("*")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        Deque<Cell> cellsToCheck = new ArrayDeque<>();
        cellsToCheck.add(new Cell(startRow, startCol));

        while (!cellsToCheck.isEmpty()) {
            Cell cell = cellsToCheck.pollFirst();

            int cellRow = cell.getRow();
            int cellCol = cell.getCol();
            int currentValue;

            if (labyrinth[cellRow][cellCol].equals("*")) {
                currentValue = 0;
            } else {
                currentValue = Integer.parseInt(labyrinth[cellRow][cellCol]);
            }

            visited[cellRow][cellCol] = true;

            boolean hasTop = cellRow > 0 && !visited[cellRow - 1][cellCol] && !labyrinth[cellRow - 1][cellCol].equals("x");
            boolean hasBottom = cellRow < labyrinth.length - 1 && !visited[cellRow + 1][cellCol] && !labyrinth[cellRow + 1][cellCol].equals("x");
            boolean hasLeft = cellCol > 0 && !visited[cellRow][cellCol - 1] && !labyrinth[cellRow][cellCol - 1].equals("x");
            boolean hasRight = cellCol < n - 1 && !visited[cellRow][cellCol + 1] && !labyrinth[cellRow][cellCol + 1].equals("x");

            if (hasTop) {
                int topRow = cellRow - 1;
                int topCol = cellCol;

                labyrinth[topRow][topCol] = Integer.toString(currentValue + 1);
                cellsToCheck.add(new Cell(topRow, topCol));
            }

            if (hasBottom) {
                int bottomRow = cellRow + 1;
                int bottomCol = cellCol;

                labyrinth[bottomRow][bottomCol] = Integer.toString(currentValue + 1);
                cellsToCheck.add(new Cell(bottomRow, bottomCol));
            }

            if (hasLeft) {
                int leftRow = cellRow;
                int leftCol = cellCol - 1;

                labyrinth[leftRow][leftCol] = Integer.toString(currentValue + 1);
                cellsToCheck.add(new Cell(leftRow, leftCol));
            }

            if (hasRight) {
                int rightRow = cellRow;
                int rightCol = cellCol + 1;

                labyrinth[rightRow][rightCol] = Integer.toString(currentValue + 1);
                cellsToCheck.add(new Cell(rightRow, rightCol));
            }
        }

        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                String element = labyrinth[i][j];

                if (element.equals("0")) {
                    System.out.print("u");
                } else {
                    System.out.print(labyrinth[i][j]);
                }
            }

            System.out.println();
        }
    }
}