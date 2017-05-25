package barracksWars.core.commands;

import barracksWars.annotations.ClassName;
import barracksWars.annotations.Inject;
import barracksWars.contracts.CommandInterpreter;
import barracksWars.contracts.Executable;
import barracksWars.contracts.Repository;
import barracksWars.contracts.UnitFactory;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File classesFolder = new File("src/barracksWars/core/commands");

        Executable executableObject = null;

        for (File file : classesFolder.listFiles()) {
            if (!file.getName().endsWith(".java")) {
                continue;
            }

            String className = file.getName().substring(0, file.getName().lastIndexOf("."));

            Class<?> executableClass = Class.forName("barracksWars.core.commands." + className);

            if (!executableClass.isAnnotationPresent(ClassName.class)) {
                continue;
            }

            if (executableClass.getDeclaredAnnotation(ClassName.class).value().equals(commandName)) {
                Constructor executableClassConstructor = executableClass.getDeclaredConstructor(data.getClass());

                executableClassConstructor.setAccessible(true);

                executableObject = (Executable) executableClassConstructor.newInstance((Object) data);

                this.injectDependency(executableClass, executableObject);
            }
        }


        return executableObject;
    }

    private void injectDependency(Class<?> exeClass, Executable object) throws IllegalAccessException {
        Field[] classFields = exeClass.getDeclaredFields();

        for (Field field : classFields) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            field.setAccessible(true);

            Field[] commandInterpreterFields = CommandInterpreterImpl.class.getDeclaredFields();

            for (Field commandInterpreterField : commandInterpreterFields) {
                if (!commandInterpreterField.getType().equals(field.getType())) {
                    continue;
                }

                commandInterpreterField.setAccessible(true);

                field.set(object, commandInterpreterField.get(this));
            }
        }
    }
}