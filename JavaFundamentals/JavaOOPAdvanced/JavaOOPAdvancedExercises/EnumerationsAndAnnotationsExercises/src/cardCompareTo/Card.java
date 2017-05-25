package cardCompareTo;

public class Card implements Comparable<Card> {

    private CardRank rank;
    private CardSuit suit;
    private int cardPower;

    public Card(String rank, String suit) {
        this.setRank(rank);
        this.setSuit(suit);

        this.calculateCardPower();
    }

    private CardRank getRank() {
        return this.rank;
    }

    private void setRank(String rank) {
        this.rank = CardRank.valueOf(rank);
    }

    private CardSuit getSuit() {
        return this.suit;
    }

    private void setSuit(String suit) {
        this.suit = CardSuit.valueOf(suit);
    }

    private void calculateCardPower() {
        this.cardPower = this.getRank().getPower() + this.getSuit().getPower();
    }

    private int getCardPower() {
        return this.cardPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.getRank(), this.getSuit(), this.getCardPower());
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getCardPower(), o.getCardPower());
    }
}