package Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        while (!command.equals("Beast!")) {
            String animalType = command;
            String[] tokens = reader.readLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender;

            switch (animalType) {
                case "Dog":
                    gender = tokens[2];

                    try {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        dog.produceSound();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Cat":
                    gender = tokens[2];

                    try {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        cat.produceSound();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Frog":
                    gender = tokens[2];

                    try {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        frog.produceSound();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Kitten":
                    try {
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        kitten.produceSound();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Tomcat":
                    try {
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        tomcat.produceSound();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Animal":
                    gender = tokens[2];

                    try {
                        Animal animal = new Animal(name, age, gender);
                        System.out.println(animal);
                        animal.produceSound();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                default:
                    System.out.println("Invalid input!");
                    break;
            }

            command = reader.readLine();
        }
    }
}