package main.bg.softuni.io;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.io.commands.Command;
import main.bg.softuni.judge.Tester;
import main.bg.softuni.network.DownloadManager;
import main.bg.softuni.repository.StudentsRepository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter {

    private static final String COMMANDS_LOCATION = "src/main/bg/softuni/io/commands/";
    private static final String COMMANDS_PACKAGE = "main.bg.softuni.io.commands.";

    private Tester tester;
    private StudentsRepository repository;
    private DownloadManager downloadManager;
    private IOManager ioManager;

    public CommandInterpreter(Tester tester,
                              StudentsRepository repository,
                              DownloadManager downloadManager,
                              IOManager ioManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();

        try {
            Command command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception ex) {
            OutputWriter.displayException(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private Command parseCommand(String input, String[] data, String command) {
        File commandsFolder = new File(COMMANDS_LOCATION);

        Command currentCommandObject = null;

        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }

            try {
                String className = file.getName().substring(0, file.getName().lastIndexOf("."));

                Class<?> commandClass = Class.forName(COMMANDS_PACKAGE + className);

                if (commandClass.isAnnotationPresent(Alias.class)) {
                    if (!commandClass.getDeclaredAnnotation(Alias.class).value().equalsIgnoreCase(command)) {
                        continue;
                    }

                    Constructor constructor = commandClass.getDeclaredConstructor(input.getClass(), data.getClass());

                    currentCommandObject = (Command) constructor.newInstance(input, data);

                    this.injectDependencies(currentCommandObject, commandClass);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return currentCommandObject;
    }

    private void injectDependencies(Command commandObject, Class<?> commandClass) throws IllegalAccessException {
        Field[] classFields = commandClass.getDeclaredFields();

        for (Field fieldToCheck : classFields) {
            if (!fieldToCheck.isAnnotationPresent(Inject.class)) {
                continue;
            }

            fieldToCheck.setAccessible(true);

            for (Field commandInterpreterField : CommandInterpreter.class.getDeclaredFields()) {
                if (!fieldToCheck.getType().equals(commandInterpreterField.getType())) {
                    continue;
                }

                commandInterpreterField.setAccessible(true);

                fieldToCheck.set(commandObject, commandInterpreterField.get(this));
            }
        }
    }
}