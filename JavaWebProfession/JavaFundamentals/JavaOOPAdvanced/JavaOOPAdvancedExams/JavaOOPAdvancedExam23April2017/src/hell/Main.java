package hell;

import hell.core.Engine;
import hell.interpretators.CommandInterpretator;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(new ConsoleReader(), new ConsoleWriter(), new CommandInterpretator());
        engine.run();
    }
}