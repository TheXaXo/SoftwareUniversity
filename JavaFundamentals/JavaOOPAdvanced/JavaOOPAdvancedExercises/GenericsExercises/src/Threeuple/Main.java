package Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        Threeuple<String, String, String> nameAddressTown = new Threeuple<String, String, String>(
                tokens[0] + " " + tokens[1], tokens[2], tokens[3]);
        System.out.println(nameAddressTown);

        tokens = reader.readLine().split(" ");

        boolean drank = false;

        if (tokens[2].equals("drunk")) {
            drank = true;
        }

        Threeuple<String, Integer, Boolean> nameBeer = new Threeuple<String, Integer, Boolean>(
                tokens[0], Integer.parseInt(tokens[1]), drank);
        System.out.println(nameBeer);

        tokens = reader.readLine().split(" ");

        Threeuple<String, Double, String> bankAccount = new Threeuple<String, Double, String>(
                tokens[0], Double.parseDouble(tokens[1]), tokens[2]);
        System.out.println(bankAccount);
    }
}