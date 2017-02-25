package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        String[] peopleArgs = reader.readLine().split(";");

        for (String personArgs : peopleArgs) {
            String[] tokens = personArgs.split("=");

            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            Person person;

            try {
                person = new Person(name, money);
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            people.add(person);
        }

        String[] productArgs = reader.readLine().split(";");

        for (String productTokens : productArgs) {
            String[] tokens = productTokens.split("=");

            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            Product product;

            try {
                product = new Product(name, price);
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            products.add(product);
        }

        String command = reader.readLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");

            String personName = tokens[0];
            String productName = tokens[1];

            Optional<Person> person = people.stream()
                    .filter(per -> per.getName().equals(personName))
                    .findFirst();

            Optional<Product> product = products.stream()
                    .filter(pro -> pro.getName().equals(productName))
                    .findFirst();

            if (person.isPresent() && product.isPresent()) {
                Person personToModify = person.get();
                Product productToModify = product.get();

                try {
                    personToModify.addProduct(productToModify);

                    System.out.printf("%s bought %s%n", personToModify.getName(), productToModify.getName());
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            command = reader.readLine();
        }

        for (Person person : people) {
            System.out.println(person);
        }
    }
}