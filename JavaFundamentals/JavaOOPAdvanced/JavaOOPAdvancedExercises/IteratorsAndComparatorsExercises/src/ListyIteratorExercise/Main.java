package ListyIteratorExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] createTokens = reader.readLine().split(" ");

        String[] items = new String[createTokens.length - 1];

        for (int i = 1; i < createTokens.length; i++) {
            items[i - 1] = createTokens[i];
        }

        ListyIterator<String> listyIterator = new ListyIterator(items);

        String command = reader.readLine();

        while (!command.equals("END")) {
            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;

                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }

            command = reader.readLine();
        }
    }
}