package app.waste_disposal.engines;

import app.waste_disposal.interpreters.CommandInterpreter;
import app.waste_disposal.interpreters.Interpreter;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    @Override
    public void run() {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        Interpreter interpreter = new CommandInterpreter();

        String command = "";

        try {
            command = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!command.equals("TimeToRecycle")) {
            String[] tokens = command.split(" ");
            String commandFromReader = tokens[0];

            if (tokens.length > 1) {
                tokens = tokens[1].split("\\|");
            }

            String result = null;

            try {
                result = interpreter.interpret(commandFromReader, tokens);
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }

            writer.write(result);

            try {
                command = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}