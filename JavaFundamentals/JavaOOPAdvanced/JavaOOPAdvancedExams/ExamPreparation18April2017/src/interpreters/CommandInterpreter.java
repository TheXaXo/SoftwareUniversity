package interpreters;

import annotations.InjectArgs;
import commands.Executable;
import core.ManagementSystem;
import core.Tracker;
import io.Writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_PATH = "commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private ManagementSystem system;
    private Writer writer;
    private Tracker tracker;

    public CommandInterpreter(ManagementSystem system, Writer writer, Tracker tracker) {
        this.system = system;
        this.writer = writer;
        this.tracker = tracker;
    }

    @SuppressWarnings("unchecked")
    public void interpretCommand(String[] tokens) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        String commandName = tokens[0];

        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PATH + commandName + COMMAND_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor(String[].class);

        Executable object = constructor.newInstance((Object) tokens);
        this.injectDependencies(object);
        object.execute();
    }

    private void injectDependencies(Executable object) throws IllegalAccessException {
        Field[] objectFields = object.getClass().getDeclaredFields();

        for (Field field : objectFields) {
            if (!field.isAnnotationPresent(InjectArgs.class)) {
                continue;
            }

            for (Field fieldFromCommandInterpreter : this.getClass().getDeclaredFields()) {
                if (field.getType().equals(fieldFromCommandInterpreter.getType())) {
                    field.setAccessible(true);
                    fieldFromCommandInterpreter.setAccessible(true);

                    field.set(object, fieldFromCommandInterpreter.get(this));
                }
            }
        }
    }
}