package hell.interpretators;

import hell.commands.Executable;
import hell.interfaces.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandInterpretator implements Interpretator {

    private static final String COMMANDS_PATH = "hell.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private Map<String, Hero> heroes;

    public CommandInterpretator() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String interpret(String command, String[] tokens) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends Executable> commandClass =
                (Class<? extends Executable>) Class.forName(COMMANDS_PATH + command + COMMAND_SUFFIX);
        Constructor<? extends Executable> constructor =
                (Constructor<? extends Executable>) commandClass.getDeclaredConstructors()[0];

        Executable commandObject = constructor.newInstance((Object) tokens, this.heroes);
        return commandObject.execute();
    }
}
