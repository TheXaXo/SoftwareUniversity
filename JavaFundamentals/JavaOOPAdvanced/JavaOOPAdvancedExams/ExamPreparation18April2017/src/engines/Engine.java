package engines;

import core.EmergencyManagementSystem;
import core.ManagementSystem;
import core.Tracker;
import interpreters.CommandInterpreter;
import interpreters.Interpreter;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine {

    public void run()
            throws IOException,
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Reader reader = new ConsoleReader();
        ManagementSystem system = new EmergencyManagementSystem();
        Writer writer = new ConsoleWriter();
        Tracker tracker = new Tracker();
        Interpreter interpreter = new CommandInterpreter(system, writer, tracker);

        String command = reader.read();

        while (!command.equals("EmergencyBreak")) {
            interpreter.interpretCommand(command.split("\\|"));

            command = reader.read();
        }
    }
}