import java.util.Scanner;

public class MaxSequenceInMatrix {
    public static void main(String[] args) {
//        40/100

        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split("\\s");

        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] rowElements = console.nextLine().split("\\s");

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = rowElements[col];
            }
        }

        int maxCount = Integer.MIN_VALUE;
        String maxElement = "";
        String element = "";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int count = 1;
                element = matrix[row][col];

                for (int colInner = col + 1; colInner < columns; colInner++) {
                    if (matrix[row][col].equals(matrix[row][colInner])) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count >= maxCount) {
                    maxCount = count;
                    maxElement = element;
                }

                count = 1;

                for (int rowInner = row + 1; rowInner < rows; rowInner++) {
                    if (matrix[row][col].equals(matrix[rowInner][col])) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count >= maxCount) {
                    maxCount = count;
                    maxElement = element;
                }

                count = 1;

                int nextIndex = col + 1;

                for (int rowInner = row + 1; rowInner < rows; rowInner++) {
                    if (matrix[rowInner].length > nextIndex &&
                            matrix[row][col].equals(matrix[rowInner][nextIndex])) {
                        count++;
                        nextIndex++;
                    } else {
                        break;
                    }
                }

                if (count >= maxCount) {
                    maxCount = count;
                    maxElement = element;
                }

                count = 1;

                nextIndex = col - 1;

                for (int rowInner = row + 1; rowInner < rows; rowInner++) {
                    if (nextIndex >= 0 &&
                            matrix[row][col].equals(matrix[rowInner][nextIndex])) {
                        count++;
                        nextIndex--;
                    } else {
                        break;
                    }
                }

                if (count >= maxCount) {
                    maxCount = count;
                    maxElement = element;
                }
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(maxElement + ", ");
        }
    }
}