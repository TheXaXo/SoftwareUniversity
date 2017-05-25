package cardSuits;

public class Main {
    public static void main(String[] args) {
        CardSuit[] suits = {CardSuit.CLUBS, CardSuit.DIAMONDS, CardSuit.HEARTS, CardSuit.SPADES};

        System.out.println("Card Suits:");
        for (CardSuit suit : suits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit);
        }
    }
}