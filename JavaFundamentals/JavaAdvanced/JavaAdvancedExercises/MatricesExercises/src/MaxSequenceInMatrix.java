import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSequenceInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArgs = reader.readLine().split(" ");

        int rows = Integer.parseInt(inputArgs[0]);
        int columns = Integer.parseInt(inputArgs[1]);

        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] rowElements = reader.readLine().split(" ");

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rowElements[j];
            }
        }

        int maxSequence = Integer.MIN_VALUE;
        String maxElement = "";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int sequence = 1;
                String element = matrix[row][col];

                for (int currentRow = row + 1; currentRow < rows; currentRow++) {
                    if (matrix[currentRow][col].equals(element)) {
                        sequence++;
                    }
                }

                if (sequence > maxSequence) {
                    maxSequence = sequence;
                    maxElement = element;
                }

                sequence = 1;

                for (int currentCol = col + 1; currentCol < columns; currentCol++) {
                    if (matrix[row][currentCol].equals(element)) {
                        sequence++;
                    }
                }

                if (sequence > maxSequence) {
                    maxSequence = sequence;
                    maxElement = element;
                }

                sequence = 1;

                int colCurrent = col + 1;

                for (int currentRow = row + 1; currentRow < rows; currentRow++) {
                    if (colCurrent >= columns) {
                        break;
                    }

                    if (matrix[currentRow][colCurrent].equals(element)) {
                        sequence++;
                        colCurrent++;
                    }
                }

                if (sequence > maxSequence) {
                    maxSequence = sequence;
                    maxElement = element;
                }

                sequence = 1;

                colCurrent = col - 1;

                for (int currentRow = row + 1; currentRow < rows; currentRow++) {
                    if (colCurrent < 0) {
                        break;
                    }

                    if (matrix[currentRow][colCurrent].equals(element)) {
                        sequence++;
                        colCurrent--;
                    }
                }

                if (sequence > maxSequence) {
                    maxSequence = sequence;
                    maxElement = element;
                }
            }
        }

        for (int i = 0; i < maxSequence; i++) {
            System.out.print(maxElement + ", ");
        }
    }
}