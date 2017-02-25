package PizzaCalories;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private Dough dough;
    private ArrayList<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.setToppings(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().length() < 1 || name.length() > 15) {
            throw new IllegalStateException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }

        this.numberOfToppings = numberOfToppings;
    }

    public Dough getDough() {
        return this.dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    private void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        this.getToppings().add(topping);
    }

    public double getTotalCalories() {
        double totalCalories = this.dough.getCalories();

        for (Topping topping : this.getToppings()) {
            totalCalories += topping.getCalories();
        }

        return totalCalories;
    }
}