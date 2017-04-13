package core;

import contracts.*;
import enumeration.EngineType;
import exeptions.*;
import factories.BoatEngineFactoryImpl;
import factories.BoatFactoryImpl;
import models.boats.Boat;
import models.engines.BoatEngine;
import utility.Constants;

import java.util.ArrayList;
import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    private Controller controller;

    private BoatFactory boatFactory;
    private BoatEngineFactory boatEngineFactory;

    public CommandHandlerImpl(Controller controller) {
        this.setController(controller);

        this.boatFactory = new BoatFactoryImpl();
        this.boatEngineFactory = new BoatEngineFactoryImpl();
    }

    public Controller getController() {
        return this.controller;
    }

    private void setController(Controller controller) {
        this.controller = controller;
    }

    public String executeCommand(String name, List<String> parameters)
            throws DuplicateModelException, NonExistentModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {

        switch (name) {
            case "CreateBoatEngine":
                BoatEngine engineToCreate;

                try {
                    engineToCreate = this.boatEngineFactory.createBoatEngine(
                            parameters.get(1),
                            Integer.parseInt(parameters.get(2)),
                            Integer.parseInt(parameters.get(3)),
                            EngineType.valueOf(parameters.get(4).toUpperCase()));
                } catch (IllegalArgumentException ex) {
                    throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
                }

                this.getController().getDatabase().getEnginesRepository().add(engineToCreate);
                return String.format(
                        "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                        engineToCreate.getModel(), engineToCreate.getHorsePower(), engineToCreate.getDisplacement());

            case "CreateRowBoat":
                Boat boat = this.boatFactory.createRowBoat(
                        parameters.get(1),
                        Integer.parseInt(parameters.get(2)),
                        Integer.parseInt(parameters.get(3)));
                this.getController().getDatabase().getBoatsRepository().add(boat);
                return this.getBoatCreationMessage(boat);

            case "CreateSailBoat":
                boat = this.boatFactory.createSailBoat(
                        parameters.get(1),
                        Integer.parseInt(parameters.get(2)),
                        Integer.parseInt(parameters.get(3)));
                this.getController().getDatabase().getBoatsRepository().add(boat);
                return this.getBoatCreationMessage(boat);

            case "CreatePowerBoat":
                BoatEngine engineOne = this.getController().getDatabase().
                        getEnginesRepository().getItem(parameters.get(3));
                BoatEngine engineTwo = this.getController().getDatabase()
                        .getEnginesRepository().getItem(parameters.get(4));

                boat = this.boatFactory.createPowerBoat(
                        parameters.get(1),
                        Integer.parseInt(parameters.get(2)),
                        engineOne,
                        engineTwo);
                this.getController().getDatabase().getBoatsRepository().add(boat);
                return this.getBoatCreationMessage(boat);

            case "CreateYacht":
                BoatEngine engine = this.getController().getDatabase().
                        getEnginesRepository().getItem(parameters.get(3));

                boat = this.boatFactory.createYacht(
                        parameters.get(1),
                        Integer.parseInt(parameters.get(2)),
                        engine,
                        Integer.parseInt(parameters.get(4)));
                this.getController().getDatabase().getBoatsRepository().add(boat);
                return this.getBoatCreationMessage(boat);

            case "OpenRace":
                return this.getController().openRace(
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Integer.parseInt(parameters.get(3)),
                        Boolean.parseBoolean(parameters.get(4)));
            case "SignUpBoat":
                return this.getController().signUpBoat(parameters.get(1));
            case "StartRace":
                return this.getController().startRace();
            case "GetStatistic":
                return this.getController().getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }

    private String getBoatCreationMessage(Modelable boat) {
        return String.format("%s with model %s registered successfully.",
                this.getBoatNameSeparatedBySpace(boat.getClass().getSimpleName()), boat.getModel());
    }

    private String getBoatNameSeparatedBySpace(String className) {
        StringBuilder sb = new StringBuilder();

        String[] words = className.split("(?=[A-Z])");

        for (int i = 1; i < words.length; i++) {
            StringBuilder wordToModify = new StringBuilder(words[i]);
            wordToModify.setCharAt(0, Character.toLowerCase(wordToModify.charAt(0)));

            words[i] = wordToModify.toString();
        }

        for (String word : words) {
            sb.append(word).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}