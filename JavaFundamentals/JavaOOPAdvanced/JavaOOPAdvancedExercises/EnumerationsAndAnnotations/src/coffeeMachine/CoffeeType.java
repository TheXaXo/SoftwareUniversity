package coffeeMachine;

public enum CoffeeType {

    ESPRESSO, LATTE, IRISH;

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}