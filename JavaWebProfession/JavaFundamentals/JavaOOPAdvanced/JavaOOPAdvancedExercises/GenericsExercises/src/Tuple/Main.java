package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        Tuple<String, String> nameAddress = new Tuple<String, String>(tokens[0] + " " + tokens[1], tokens[2]);
        System.out.println(nameAddress);

        tokens = reader.readLine().split(" ");

        Tuple<String, Integer> nameBeer = new Tuple<String, Integer>(tokens[0], Integer.parseInt(tokens[1]));
        System.out.println(nameBeer);

        tokens = reader.readLine().split(" ");

        Tuple<Integer, Double> integerDouble = new Tuple<Integer, Double>(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]));
        System.out.println(integerDouble);
    }
}