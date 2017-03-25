package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        List<Person> people = new ArrayList<>();

        while (!command.equals("END")) {
            String[] tokens = command.split(" ");

            people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));

            command = reader.readLine();
        }

        int index = Integer.parseInt(reader.readLine());

        if (index > people.size() - 1) {
            System.out.println("No matches");
            return;
        }

        int numberOfEqual = 0;

        Person personToCompareTo = people.get(index);

        for (Person person : people) {
            if (person.compareTo(personToCompareTo) == 0) {
                numberOfEqual++;
            }
        }

        System.out.printf("%d %d %d", numberOfEqual, people.size() - numberOfEqual, people.size());
    }
}