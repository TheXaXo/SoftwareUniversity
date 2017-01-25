import java.util.LinkedHashSet;
import java.util.Scanner;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] playerOneNumbersStr = console.nextLine().split(" ");
        String[] playerTwoNumbersStr = console.nextLine().split(" ");

        LinkedHashSet<Integer> playerOneCards = new LinkedHashSet<>();
        LinkedHashSet<Integer> playerTwoCards = new LinkedHashSet<>();

        for (String numberStr : playerOneNumbersStr) {
            playerOneCards.add(Integer.parseInt(numberStr));
        }

        for (String numberStr : playerTwoNumbersStr) {
            playerTwoCards.add(Integer.parseInt(numberStr));
        }

        int count = 0;

        while ((!playerOneCards.isEmpty() && !playerTwoCards.isEmpty()) &&
                count <= 50) {
            int playerOneTopCard = playerOneCards.iterator().next();
            int playerTwoTopCard = playerTwoCards.iterator().next();

            if (playerOneTopCard > playerTwoTopCard) {
                playerTwoCards.remove(playerTwoTopCard);

                playerOneCards.remove(playerOneTopCard);
                playerOneCards.add(playerOneTopCard);

                playerOneCards.add(playerTwoTopCard);
            } else if (playerTwoTopCard > playerOneTopCard) {
                playerOneCards.remove(playerOneTopCard);

                playerTwoCards.remove(playerTwoTopCard);
                playerTwoCards.add(playerTwoTopCard);

                playerTwoCards.add(playerOneTopCard);
            } else {
                playerOneCards.remove(playerOneTopCard);
                playerTwoCards.remove(playerTwoTopCard);
            }

            count++;
        }

        if ((playerOneCards.size() == playerTwoCards.size())) {
            System.out.println("Draw!");
        } else if (playerOneCards.size() > playerTwoCards.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}