package coffeeMachine;

public enum Coin {

    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private int amount;

    private Coin(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}