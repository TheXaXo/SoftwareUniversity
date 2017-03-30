package barracksWars.core;

import barracksWars.contracts.*;
import barracksWars.contracts.Runnable;
import barracksWars.core.commands.CommandInterpreterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private CommandInterpreterImpl commandInterpreter;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");

                String commandName = data[0];
                String result = interpretCommand(data, commandName);

                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | InstantiationException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Executable executable = this.commandInterpreter.interpretCommand(data, commandName);

        return executable.execute();
    }
}