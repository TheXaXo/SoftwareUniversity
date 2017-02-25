package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private int weight;

    public Dough(String flourType, String bakingTechnique, int weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private String getFlourType() {
        return this.flourType;
    }

    private void setFlourType(String flourType) {
        if (!(flourType.toLowerCase().equals("white") || flourType.toLowerCase().equals("wholegrain"))) {
            throw new IllegalStateException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.toLowerCase().equals("crispy")
                && !bakingTechnique.toLowerCase().equals("chewy")
                && !bakingTechnique.toLowerCase().equals("homemade")) {
            throw new IllegalStateException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique.toLowerCase();
    }

    private double getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalStateException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public double getCalories() {
        double modifierOne = 0;
        double modifierTwo = 0;

        switch (this.getFlourType().toLowerCase()) {
            case "white":
                modifierOne = 1.5;
                break;

            case "wholegrain":
                modifierOne = 1;
                break;
        }

        switch (this.getBakingTechnique()) {
            case "crispy":
                modifierTwo = 0.9;
                break;

            case "chewy":
                modifierTwo = 1.1;
                break;

            case "homemade":
                modifierTwo = 1;
                break;
        }

        return 2 * this.getWeight() * modifierOne * modifierTwo;
    }
}