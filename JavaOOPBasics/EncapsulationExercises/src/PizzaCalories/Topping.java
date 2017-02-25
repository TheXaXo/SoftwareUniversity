package PizzaCalories;

public class Topping {
    private String type;
    private int weight;

    public Topping(String type, int weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private String getType() {
        return this.type;
    }

    private void setType(String type) {
        if (!type.toLowerCase().equals("meat")
                && !type.toLowerCase().equals("veggies")
                && !type.toLowerCase().equals("cheese")
                && !type.toLowerCase().equals("sauce")) {
            throw new IllegalStateException(String.format("Cannot place %s on top of your pizza.", type));
        }

        this.type = type;
    }

    private int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalStateException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }

        this.weight = weight;
    }

    public double getCalories() {
        double modifier = 0;

        switch (this.getType().toLowerCase()) {
            case "meat":
                modifier = 1.2;
                break;

            case "veggies":
                modifier = 0.8;
                break;

            case "cheese":
                modifier = 1.1;
                break;

            case "sauce":
                modifier = 0.9;
                break;
        }

        return 2 * modifier * this.getWeight();
    }
}