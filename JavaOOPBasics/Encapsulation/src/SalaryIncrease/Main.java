package SalaryIncrease;

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

            Person person = new Person(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
            people.add(person);
        }

        int bonus = Integer.parseInt(reader.readLine());

        for (Person person : people) {
            person.increaseSalary(bonus);

            System.out.println(person);
        }
    }
}