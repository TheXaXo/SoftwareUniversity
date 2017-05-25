package warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String threshold = reader.readLine();

        Logger logger = new Logger(threshold);

        String command = reader.readLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(": ");

            String level = tokens[0];
            String messageText = tokens[1];

            Message message = new Message(level, messageText);
            logger.receiveMessage(message);

            command = reader.readLine();
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}