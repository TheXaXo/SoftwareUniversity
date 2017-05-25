package StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Person> setOne = new TreeSet<>(new PersonComparatorOne());
        Set<Person> setTwo = new TreeSet<>(new PersonComparatorTwo());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            setOne.add(person);
            setTwo.add(person);
        }

        for (Person person : setOne) {
            System.out.println(person);
        }

        for (Person person : setTwo) {
            System.out.println(person);
        }
    }
}