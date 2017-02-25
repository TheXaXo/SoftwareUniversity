package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        HashSet<Person> people = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(person -> person.getName()))
                .forEach(person -> System.out.printf("%s - %s%n", person.getName(), person.getAge()));
    }
}