package cardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Card>> playerCards = new HashMap<>();

        String playerOne = reader.readLine();
        String playerTwo = reader.readLine();

        int deckSize = 0;

        String currentPlayer = playerOne;

        while (deckSize < 5) {
            String[] tokens = reader.readLine().split(" ");

            String rank = tokens[0];
            String suit = tokens[2];

            Card card;

            try {
                card = new Card(rank, suit);
            } catch (IllegalArgumentException ex) {
                System.out.println("No such card exists.");
                continue;
            }

            playerCards.putIfAbsent(currentPlayer, new ArrayList<>());

            if (playerCards.get(currentPlayer).stream().anyMatch(a -> a.compareTo(card) == 0)) {
                System.out.println("Card is not in the deck.");
                continue;
            }

            playerCards.get(currentPlayer).add(card);
            deckSize++;

            if (deckSize == 5 && currentPlayer.equals(playerOne)) {
                deckSize = 0;
                currentPlayer = playerTwo;
            }
        }

        Optional<Card> playerOneHighestOptional = playerCards.get(playerOne).stream()
                .sorted((a, b) -> b.compareTo(a))
                .findFirst();
        Optional<Card> playerTwoHighestOptional = playerCards.get(playerTwo).stream()
                .sorted((a, b) -> b.compareTo(a))
                .findFirst();

        if (playerOneHighestOptional.isPresent() && playerTwoHighestOptional.isPresent()) {
            Card cardPlayerOne = playerOneHighestOptional.get();
            Card cardPlayerTwo = playerTwoHighestOptional.get();

            if (cardPlayerOne.compareTo(cardPlayerTwo) > 0) {
                System.out.printf("%s wins with %s.", playerOne, cardPlayerOne);
            } else {
                System.out.printf("%s wins with %s.", playerTwo, cardPlayerTwo);
            }
        }
    }
}