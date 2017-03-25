package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        CustomStack stack = new CustomStack();

        while (!command.equals("END")) {
            String[] tokens = Arrays.stream(command.split("[,\\s]"))
                    .filter(a -> a.length() != 0)
                    .toArray(String[]::new);

            switch (tokens[0]) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }

                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
            }

            command = reader.readLine();
        }

        for (int i = 0; i < 2; i++) {
            for (int number : stack) {
                System.out.println(number);
            }
        }
    }
}