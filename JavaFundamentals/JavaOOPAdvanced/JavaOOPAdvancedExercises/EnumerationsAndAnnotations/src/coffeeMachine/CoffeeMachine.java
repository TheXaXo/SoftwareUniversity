package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private int moneyInserted;
    private List<Coffee> coffeesSold;

    public CoffeeMachine() {
        this.moneyInserted = 0;
        this.coffeesSold = new ArrayList<>();
    }

    public void insertCoin(String coin) {
        Coin coinInserted = Coin.valueOf(coin);
        this.moneyInserted += coinInserted.getAmount();
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(size, type);

        if (coffee.getSize().getPrice() <= this.moneyInserted) {
            this.moneyInserted = 0;
            this.coffeesSold.add(coffee);
        }
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeesSold;
    }
}