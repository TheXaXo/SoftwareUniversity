package SortPersons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            people.add(person);
        }

        people.stream()
                .sorted((p1, p2) -> {
                    int result = p1.getFirstName().compareTo(p2.getFirstName());

                    if (result == 0) {
                        Integer p1Age = p1.getAge();
                        Integer p2Age = p2.getAge();

                        result = p1Age.compareTo(p2Age);
                    }

                    return result;
                })
                .forEach(person -> System.out.println(person));
    }
}