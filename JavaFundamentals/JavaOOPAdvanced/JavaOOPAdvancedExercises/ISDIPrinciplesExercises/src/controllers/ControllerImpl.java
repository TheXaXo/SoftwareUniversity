package controllers;

import contracts.Controller;
import contracts.Race;
import database.Database;
import exeptions.*;
import models.RaceImpl;
import models.boats.Boat;
import utility.Constants;

import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller {

    private static final int NEEDED_WINNERS_COUNT = 3;

    private Database database;
    private Race currentRace;

    public ControllerImpl() {
        this.setDatabase(new Database());
        this.setCurrentRace(null);
    }

    @Override
    public Database getDatabase() {
        return this.database;
    }

    private void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public Race getCurrentRace() {
        return this.currentRace;
    }

    private void setCurrentRace(Race currentRace) {
        this.currentRace = currentRace;
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        this.validateRaceIsEmpty();
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.setCurrentRace(race);

        return String.format("A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistentModelException, DuplicateModelException, NoSetRaceException {
        this.validateRaceIsSet();
        Boat boat = this.database.getBoatsRepository().getItem(model);

        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getRegisteredBoatsRepository().getItems();

        if (participants.size() < NEEDED_WINNERS_COUNT) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        StringBuilder result = new StringBuilder();
        int currentParticipantPosition = 1;

        for (Map.Entry<Boat, Double> winnerTime : this.getCurrentRace().getWinners(NEEDED_WINNERS_COUNT)) {
            result.append(String.format("%s place: %s Model: %s Time: %s%n",
                    this.getPositionNameByIndex(currentParticipantPosition++),
                    winnerTime.getKey().getClass().getSimpleName(),
                    winnerTime.getKey().getModel(),
                    this.isFinished(winnerTime.getValue())));
        }

        this.currentRace = null;
        return result.toString();
    }

    private String isFinished(Double key) {
        if (key == Double.MAX_VALUE) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", key);
    }

    @Override
    public String getStatistic() {
        return null;
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }

    private String getPositionNameByIndex(int index) {

        switch (index) {
            case 1:
                return "First";
            case 2:
                return "Second";
            case 3:
                return "Third";
            default:
                return "Invalid position!";
        }
    }
}