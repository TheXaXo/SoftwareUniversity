package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandlerImpl commandHandlerImpl;

    public Engine(CommandHandlerImpl commandHandlerImpl) {
        this.commandHandlerImpl = commandHandlerImpl;
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> tokens;

        while (true) {
            String line = reader.readLine();

            if (line.equals("End")) {
                break;
            }

            tokens = Arrays.stream(line.split("\\\\")).collect(Collectors.toList());

            try {
                String commandResult = this.commandHandlerImpl.executeCommand(tokens.get(0), tokens);
                System.out.println(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}