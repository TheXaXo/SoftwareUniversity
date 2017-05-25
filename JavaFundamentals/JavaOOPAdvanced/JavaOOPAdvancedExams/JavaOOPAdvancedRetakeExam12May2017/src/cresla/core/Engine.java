package cresla.core;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.InputReaderImpl;
import cresla.io.OutputWriterImpl;
import cresla.managers.ManagerImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {

    private static final String MANAGER_PATH = "cresla.managers.ManagerImpl";
    private static final String COMMAND_SUFFIX = "Command";

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine() {
        this.reader = new InputReaderImpl();
        this.writer = new OutputWriterImpl();
        this.manager = new ManagerImpl();
    }

    @Override
    public void run() {
        String command = this.reader.readLine();

        while (!command.equals("Exit")) {
            String[] tokens = command.split(" ");
            String output = null;

            try {
                output = this.interpretCommand(tokens);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            this.writer.writeLine(output);
            command = this.reader.readLine();
        }

        try {
            this.writer.writeLine(this.interpretCommand(command.split(" ")));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private String interpretCommand(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String commandName = tokens[0].toLowerCase();

        Class<Manager> managerClass = (Class<Manager>) Class.forName(MANAGER_PATH);
        Method commandMethod = managerClass.getDeclaredMethod(commandName + COMMAND_SUFFIX, List.class);

        return (String) commandMethod.invoke(this.manager, Arrays.asList(tokens));
    }
}