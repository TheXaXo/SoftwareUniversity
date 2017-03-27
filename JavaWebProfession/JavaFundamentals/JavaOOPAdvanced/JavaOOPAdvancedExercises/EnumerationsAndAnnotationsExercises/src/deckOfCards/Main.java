package deckOfCards;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CardRank[] ranks = CardRank.values();
        CardSuit[] suits = CardSuit.values();

        for (CardSuit suit : suits) {
            for (CardRank rank : ranks) {
                System.out.printf("%s of %s%n", rank, suit);
            }
        }
    }
}