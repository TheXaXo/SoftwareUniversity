package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        HashSet<Person> people = new HashSet<>();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            String name = tokens[0];
            String typeOfCommand = tokens[1];

            Person person = new Person(name);
            boolean isAlreadyContained = false;

            for (Person personToCheck : people) {
                if (personToCheck.getName().equals(name)) {
                    person = personToCheck;
                    isAlreadyContained = true;
                    break;
                }
            }

            switch (typeOfCommand) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    person.addPokemon(pokemon);
                    break;

                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Relative parent = new Relative(parentName, parentBirthday);

                    person.addParent(parent);
                    break;

                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Relative child = new Relative(childName, childBirthday);

                    person.addChild(child);
                    break;

                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);

                    person.setCar(car);
                    break;
            }

            if (!isAlreadyContained) {
                people.add(person);
            }

            command = reader.readLine();
        }

        String personToDisplay = reader.readLine();

        people.stream().filter(person -> person.getName().equals(personToDisplay))
                .limit(1)
                .forEach(person -> System.out.println(person));
    }
}