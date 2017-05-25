package blobs.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        CommandInterpreter commandInterpreter = new CommandInterpreter();

        while (!command.equals("drop")) {
            String[] tokens = command.split(" ");
            commandInterpreter.interpretCommand(tokens);
            commandInterpreter.updateBlobs();

            command = reader.readLine();
        }
    }
}