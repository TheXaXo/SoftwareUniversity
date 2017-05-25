package hell.core;

import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.interpretators.Interpretator;

import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Interpretator interpretator;

    public Engine(InputReader reader, OutputWriter writer, Interpretator interpretator) {
        this.reader = reader;
        this.writer = writer;
        this.interpretator = interpretator;
    }

    @Override
    public void run() {
        String[] tokens = this.reader.readLine().split(" ");
        String command = tokens[0];

        while (true) {
            try {
                this.writer.writeLine(this.interpretator.interpret(command, tokens));
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (command.equals("Quit")) {
                break;
            }

            tokens = reader.readLine().split(" ");
            command = tokens[0];
        }
    }
}