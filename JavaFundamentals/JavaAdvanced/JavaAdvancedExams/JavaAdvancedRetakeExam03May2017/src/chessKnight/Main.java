package chessKnight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] cards = new char[8][8];
        List<String> takenCards = new ArrayList<>();

        int invalidMovesCount = 0;
        int outOfBoardCount = 0;

        for (int i = 0; i < 8; i++) {
            String[] tokens = Arrays.stream(reader.readLine().split("\\|"))
                    .filter(token -> token.length() > 0)
                    .toArray(String[]::new);

            for (int j = 0; j < tokens.length; j++) {
                cards[i][j] = tokens[j].charAt(0);
            }
        }

        String knightCoordinates = reader.readLine();
        int knightRow = Integer.parseInt(Character.toString(knightCoordinates.charAt(0)));
        int knightCol = Integer.parseInt(Character.toString(knightCoordinates.charAt(1)));

        String command = reader.readLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" -> ");

            int newRow = Integer.parseInt(Character.toString(tokens[1].charAt(0)));
            int newCol = Integer.parseInt(Character.toString(tokens[1].charAt(1)));

            boolean isValidMove = isValidMove(knightRow, knightCol, newRow, newCol);
            boolean isOut = newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7;

            if (isValidMove && !isOut) {
                knightRow = newRow;
                knightCol = newCol;

                if (cards[knightRow][knightCol] != ' ') {
                    takenCards.add(Character.toString(cards[knightRow][knightCol]));
                    cards[knightRow][knightCol] = ' ';
                }
            } else {
                if (!isValidMove) {
                    invalidMovesCount++;
                } else {
                    outOfBoardCount++;
                }
            }

            command = reader.readLine();
        }

        System.out.printf("Pieces take: %s\nInvalid moves: %d\nBoard out moves: %d",
                String.join(", ", takenCards), invalidMovesCount, outOfBoardCount);
    }

    private static boolean isValidMove(int knightRow, int knightCol, int newRow, int newCol) {
        return (Math.abs(knightRow - newRow) == 1 && Math.abs(knightCol - newCol) == 2) ||
                (Math.abs(knightRow - newRow) == 2 && Math.abs(knightCol - newCol) == 1);
    }
}
