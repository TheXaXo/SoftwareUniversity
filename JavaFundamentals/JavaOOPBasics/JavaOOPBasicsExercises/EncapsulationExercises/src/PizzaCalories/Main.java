package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");

            if (tokens[0].equals("Pizza")) {
                String pizzaName = tokens[1];
                int pizzaNumberOfToppings = Integer.parseInt(tokens[2]);

                Pizza pizza;

                try {
                    pizza = new Pizza(pizzaName, pizzaNumberOfToppings);
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

                String[] doughTokens = reader.readLine().split(" ");

                String doughType = doughTokens[1];
                String doughTechnique = doughTokens[2];
                int doughWeight = Integer.parseInt(doughTokens[3]);

                Dough dough;

                try {
                    dough = new Dough(doughType, doughTechnique, doughWeight);
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

                pizza.setDough(dough);

                for (int i = 0; i < pizzaNumberOfToppings; i++) {
                    String[] toppingTokens = reader.readLine().split(" ");

                    String toppingName = toppingTokens[1];
                    int toppingWeight = Integer.parseInt(toppingTokens[2]);

                    Topping topping;

                    try {
                        topping = new Topping(toppingName, toppingWeight);
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }

                    pizza.addTopping(topping);
                }

                System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getTotalCalories());
            } else if (tokens[0].equals("Dough")) {
                String doughType = tokens[1];
                String doughTechnique = tokens[2];
                int doughWeight = Integer.parseInt(tokens[3]);

                Dough dough;

                try {
                    dough = new Dough(doughType, doughTechnique, doughWeight);
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

                System.out.printf("%.2f%n", dough.getCalories());
            } else {
                String toppingName = tokens[1];
                int toppingWeight = Integer.parseInt(tokens[2]);

                Topping topping;

                try {
                    topping = new Topping(toppingName, toppingWeight);
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

                System.out.printf("%.2f%n", topping.getCalories());
            }

            command = reader.readLine();
        }
    }
}