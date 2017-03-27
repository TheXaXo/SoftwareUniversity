package cardRank;

public class Main {
    public static void main(String[] args) {
        CardRank[] cardRanks = {CardRank.ACE, CardRank.TWO, CardRank.THREE, CardRank.FOUR,
                CardRank.FIVE, CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT, CardRank.NINE,
                CardRank.TEN, CardRank.JACK, CardRank.QUEEN, CardRank.KING};

        System.out.println("Card Ranks:");
        for (CardRank cardRank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank);
        }
    }
}