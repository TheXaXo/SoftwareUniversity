package avatar.core;

import avatar.interpreters.CommandInterpreter;
import avatar.interpreters.Interpreter;
import avatar.io.ConsoleReader;
import avatar.io.ConsoleWriter;
import avatar.io.Reader;
import avatar.io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private Interpreter interpreter;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.interpreter = new CommandInterpreter();
    }

    @Override
    public void run() {

        String command = null;

        try {
            command = this.reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            String[] tokens = command.split(" ");
            String output = null;

            try {
                output = this.interpreter.interpretCommand(tokens);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (output != null) {
                this.writer.write(output);
            }

            if (command.equals("Quit")) {
                break;
            }

            try {
                command = this.reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}