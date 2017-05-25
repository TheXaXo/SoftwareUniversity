package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Lake lake = new Lake();

        int[] numbers = Arrays.stream(command.split("[,\\s]"))
                .filter(a -> a.length() > 0)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int number : numbers) {
            lake.addNumber(number);
        }

        System.out.println(lake);
    }
}