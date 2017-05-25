package avatar.interpreters;

import avatar.annotations.Inject;
import avatar.commands.Executable;
import avatar.models.nations.Nation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_PACKAGE = "avatar.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private Map<String, Nation> nations;
    private List<String> issuedWarsByNations;

    public CommandInterpreter() {
        this.nations = new LinkedHashMap<>();
        this.issuedWarsByNations = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String interpretCommand(String[] tokens) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String commandName = tokens[0];

        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + commandName + COMMAND_SUFFIX);
        Constructor<Executable> constructor = (Constructor<Executable>) commandClass.getDeclaredConstructors()[0];

        Executable commandObject = constructor.newInstance((Object) tokens);
        this.injectDependencies(commandClass, commandObject);

        return commandObject.execute();
    }

    private void injectDependencies(Class<Executable> executableClass, Executable executableObject) throws IllegalAccessException {
        Field[] executableFields = executableClass.getDeclaredFields();

        for (Field executableField : executableFields) {
            if (!executableField.isAnnotationPresent(Inject.class)) {
                continue;
            }

            executableField.setAccessible(true);

            for (Field interpreterField : this.getClass().getDeclaredFields()) {
                if (!executableField.getType().equals(interpreterField.getType())) {
                    continue;
                }

                interpreterField.setAccessible(true);
                executableField.set(executableObject, interpreterField.get(this));
            }
        }
    }
}