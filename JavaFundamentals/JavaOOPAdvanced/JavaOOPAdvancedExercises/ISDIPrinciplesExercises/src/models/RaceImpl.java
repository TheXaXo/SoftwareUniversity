package models;

import contracts.Race;
import contracts.Repository;
import database.RepositoryImpl;
import exeptions.DuplicateModelException;
import models.boats.Boat;
import utility.Validator;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceImpl implements Race {

    private static final double DID_NOT_FINISH_TIME = Double.MAX_VALUE;

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Repository<Boat> registeredBoatsRepository;

    @SuppressWarnings("unchecked")
    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoatsRepository = new RepositoryImpl<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    public Repository<Boat> getRegisteredBoatsRepository() {
        return this.registeredBoatsRepository;
    }

    public void addParticipant(Boat boat) throws DuplicateModelException {
        this.getRegisteredBoatsRepository().add(boat);
    }

    @Override
    public List<Map.Entry<Boat, Double>> getWinners(int winnersCount) {
        Map<Boat, Double> winnersTime = new LinkedHashMap<>();
        List<Boat> raceRegisteredParticipants = this.getRegisteredBoatsRepository().getItems();

        for (int i = 0; i < winnersCount; i++) {
            Double bestTime = null;
            Boat winner = null;

            for (Boat participant : raceRegisteredParticipants) {
                double raceTime = participant.getRaceTime(this);

                if (raceTime < 0) {
                    raceTime = DID_NOT_FINISH_TIME;
                }

                if (bestTime == null || raceTime < bestTime) {
                    bestTime = raceTime;
                    winner = participant;
                }
            }

            winnersTime.put(winner, bestTime);
            raceRegisteredParticipants.remove(winner);
        }

        return winnersTime.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .collect(Collectors.toList());
    }
}