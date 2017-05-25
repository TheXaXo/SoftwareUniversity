package coffeeMachine;

public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.setSize(size);
        this.setType(type);
    }

    public CoffeeSize getSize() {
        return this.size;
    }

    private void setSize(String size) {
        this.size = CoffeeSize.valueOf(size.toUpperCase());
    }

    public CoffeeType getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = CoffeeType.valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return this.size + " " + this.type;
    }
}