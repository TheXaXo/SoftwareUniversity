package Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Smartphone smartphone = new Smartphone();

        String[] phoneNumbers = reader.readLine().split(" ");

        for (String number : phoneNumbers) {
            try {
                System.out.println(smartphone.phone(number));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        String[] websites = reader.readLine().split(" ");

        for (String website : websites) {
            try {
                System.out.println(smartphone.browse(website));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}