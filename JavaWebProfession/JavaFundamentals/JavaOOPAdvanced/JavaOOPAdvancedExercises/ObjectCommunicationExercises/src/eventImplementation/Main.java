package eventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangerListener(handler);

        String command = reader.readLine();

        while (!command.equals("End")) {
            dispatcher.setName(command);
            command = reader.readLine();
        }
    }
}