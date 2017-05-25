package app.waste_disposal.interpreters;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.annotations.Inject;
import app.waste_disposal.commands.Executable;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.models.ManagementRequirement;
import app.waste_disposal.repository.Repository;
import app.waste_disposal.repository.RepositoryImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_PATH = "app.waste_disposal.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private Repository repository;
    private GarbageProcessor garbageProcessor;
    private ManagementRequirement managementRequirement;

    public CommandInterpreter() {
        this.repository = new RepositoryImpl();
        this.garbageProcessor = new DefaultGarbageProcessor();
        this.managementRequirement = new ManagementRequirement();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String interpret(String command, String[] tokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Executable> classToInitialize = (Class<Executable>) Class.forName(COMMANDS_PATH + command + COMMAND_SUFFIX);
        Constructor<Executable> constructor = classToInitialize.getDeclaredConstructor(String[].class);

        Executable executable = constructor.newInstance((Object) tokens);

        this.injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executableObject) throws IllegalAccessException {
        Field[] fields = executableObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            for (Field fieldFromInterpreter : this.getClass().getDeclaredFields()) {
                if (!field.getType().equals(fieldFromInterpreter.getType())) {
                    continue;
                }

                field.setAccessible(true);
                fieldFromInterpreter.setAccessible(true);
                field.set(executableObject, fieldFromInterpreter.get(this));
            }
        }
    }
}