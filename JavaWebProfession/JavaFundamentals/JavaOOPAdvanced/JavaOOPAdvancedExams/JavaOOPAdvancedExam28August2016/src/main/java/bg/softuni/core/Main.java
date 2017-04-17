package bg.softuni.core;

import bg.softuni.logger.ConsoleLogger;
import bg.softuni.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws
            IOException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EmergencyManagementSystem system = new EmergencyManagementSystem();
        Logger logger = new ConsoleLogger();
        Tracker tracker = new Tracker();
        CommandInterpreter interpreter = new CommandInterpreter(system, logger, tracker);

        String command = reader.readLine();

        while (!command.equals("EmergencyBreak")) {
            interpreter.interpretCommand(command.split("\\|"));

            command = reader.readLine();
        }
    }
}