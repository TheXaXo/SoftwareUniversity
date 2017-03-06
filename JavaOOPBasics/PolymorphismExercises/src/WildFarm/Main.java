package WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] animalTokens = command.split(" ");

            String type = animalTokens[0];
            String name = animalTokens[1];
            double weight = Double.parseDouble(animalTokens[2]);
            String region = animalTokens[3];

            String[] foodTokens = reader.readLine().split(" ");

            String foodType = foodTokens[0];
            int foodQuantity = Integer.parseInt(foodTokens[1]);


            Food foodToEat;

            if (foodType.equals("Vegetable")) {
                foodToEat = new Vegetable(foodQuantity);
            } else {
                foodToEat = new Meat(foodQuantity);
            }

            if (type.equals("Cat")) {
                String breed = animalTokens[4];

                Cat cat = new Cat(name, type, weight, region, breed);
                cat.makeSound();

                try {
                    cat.eat(foodToEat);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

                System.out.println(cat);
            } else if (type.equals("Mouse")) {
                Mouse mouse = new Mouse(name, type, weight, region);

                mouse.makeSound();

                try {
                    mouse.eat(foodToEat);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

                System.out.println(mouse);
            } else if (type.equals("Zebra")) {
                Zebra zebra = new Zebra(name, type, weight, region);

                zebra.makeSound();

                try {
                    zebra.eat(foodToEat);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

                System.out.println(zebra);
            } else if (type.equals("Tiger")) {
                Tiger tiger = new Tiger(name, type, weight, region);

                tiger.makeSound();

                try {
                    tiger.eat(foodToEat);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(tiger);
            }

            command = reader.readLine();
        }
    }
}
