import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LegoBlocks {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        int[][] matrixOne = new int[rows][];
        int[][] matrixTwo = new int[rows][];

        int totalNumberOfCells = 0;

        for (int i = 0; i < rows; i++) {
            String[] rowElements = console.nextLine().split("\\s+");
            rowElements = Arrays.stream(rowElements)
                    .filter(a -> a.length() > 0)
                    .toArray(String[]::new);

            matrixOne[i] = new int[rowElements.length];

            for (int j = 0; j < matrixOne[i].length; j++) {
                matrixOne[i][j] = Integer.parseInt(rowElements[j]);
                totalNumberOfCells++;
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] rowElements = console.nextLine().split("\\s+");
            rowElements = Arrays.stream(rowElements)
                    .filter(a -> a.length() > 0)
                    .toArray(String[]::new);

            int currentElementIndex = rowElements.length - 1;

            matrixTwo[i] = new int[rowElements.length];

            for (int j = 0; j < matrixTwo[i].length; j++) {
                matrixTwo[i][j] = Integer.parseInt(rowElements[currentElementIndex]);
                totalNumberOfCells++;

                currentElementIndex--;
            }
        }

        ArrayList<ArrayList<Integer>> combinedMatrix = new ArrayList<>();

        for (int row = 0; row < matrixOne.length; row++) {
            combinedMatrix.add(row, new ArrayList<>());

            for (int colMatrixOne = 0; colMatrixOne < matrixOne[row].length; colMatrixOne++) {
                combinedMatrix.get(row).add(matrixOne[row][colMatrixOne]);
            }

            for (int colMatrixTwo = 0; colMatrixTwo < matrixTwo[row].length; colMatrixTwo++) {
                combinedMatrix.get(row).add(matrixTwo[row][colMatrixTwo]);
            }
        }

        int columns = combinedMatrix.get(0).size();

        boolean doesNotFit = false;

        for (int i = 1; i < combinedMatrix.size(); i++) {
            if (combinedMatrix.get(i).size() != columns) {
                doesNotFit = true;
                break;
            }
        }

        if (doesNotFit) {
            System.out.println("The total number of cells is: " + totalNumberOfCells);
        } else {
            for (int i = 0; i < combinedMatrix.size(); i++) {
                StringBuilder rowForPrint = new StringBuilder();
                rowForPrint.append("[");

                for (int j = 0; j < combinedMatrix.get(i).size(); j++) {
                    if (j != combinedMatrix.get(i).size() - 1) {
                        rowForPrint.append(combinedMatrix.get(i).get(j));
                        rowForPrint.append(", ");
                    } else {
                        rowForPrint.append(combinedMatrix.get(i).get(j));
                        rowForPrint.append("]");
                    }
                }

                System.out.println(rowForPrint.toString());
            }
        }
    }
}