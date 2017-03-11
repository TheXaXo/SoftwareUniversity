package Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        String firstName = tokens[0];
        String lastName = tokens[1];
        String facultyNumber = tokens[2];

        Student student;

        try {
            student = new Student(firstName, lastName, facultyNumber);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(student);

        tokens = reader.readLine().split(" ");

        firstName = tokens[0];
        lastName = tokens[1];
        double salary = Double.parseDouble(tokens[2]);
        double workHours = Double.parseDouble(tokens[3]);

        Worker worker;

        try {
            worker = new Worker(firstName, lastName, salary, workHours);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println();
        System.out.println(worker);
    }
}