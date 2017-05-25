package coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");

            if (tokens.length == 1) {
                coffeeMachine.insertCoin(tokens[0]);
            } else {
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }

            command = reader.readLine();
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}