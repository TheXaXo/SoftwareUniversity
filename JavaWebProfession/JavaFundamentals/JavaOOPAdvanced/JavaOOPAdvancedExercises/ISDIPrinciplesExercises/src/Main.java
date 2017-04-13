import contracts.Controller;
import controllers.ControllerImpl;
import core.CommandHandlerImpl;
import core.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller boatSimulatorController = new ControllerImpl();
        CommandHandlerImpl commandHandlerImpl = new CommandHandlerImpl(boatSimulatorController);

        Engine engine = new Engine(commandHandlerImpl);
        engine.run();
    }
}