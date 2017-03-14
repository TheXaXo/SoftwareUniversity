package needforspeed;

import java.util.HashMap;

public class CarManager {

    private HashMap<Integer, Car> cars;
    private HashMap<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        switch (type) {
            case "Performance":
                PerformanceCar performanceCar = new PerformanceCar(brand, model, yearOfProduction,
                        horsepower, acceleration, suspension, durability);

                this.cars.put(id, performanceCar);
                break;

            case "Show":
                ShowCar showCar = new ShowCar(brand, model, yearOfProduction,
                        horsepower, acceleration, suspension, durability);
                this.cars.put(id, showCar);
                break;
        }
    }

    public String check(int id) {
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        switch (type) {
            case "Casual":
                CasualRace casualRace = new CasualRace(length, route, prizePool);

                this.races.put(id, casualRace);
                break;

            case "Drag":
                DragRace dragRace = new DragRace(length, route, prizePool);

                this.races.put(id, dragRace);
                break;

            case "Drift":
                DriftRace driftRace = new DriftRace(length, route, prizePool);

                this.races.put(id, driftRace);
                break;
        }
    }

    public void open(int id, String type, int length, String route, int prizePool, int extraParameter) {
        switch (type) {
            case "TimeLimit":
                TimeLimitRace timeLimitRace = new TimeLimitRace(length, route, prizePool, extraParameter);

                this.races.put(id, timeLimitRace);
                break;

            case "Circuit":
                CircuitRace circuitRace = new CircuitRace(length, route, prizePool, extraParameter);

                this.races.put(id, circuitRace);
                break;
        }
    }

    public void participate(int carId, int raceId) {
        if (!this.garage.getParkedCars().contains(this.cars.get(carId)) && !this.races.get(raceId).getIsClosed()) {
            Race race = this.races.get(raceId);
            race.addParticipant(this.cars.get(carId));
        }
    }

    public String start(int id) {
        if (this.races.get(id).getParticipants().isEmpty()) {
            return "Cannot start the race with zero participants.\n";
        } else if (this.races.get(id).getIsClosed()) {
            return "";
        }

        String outPut = this.races.get(id).toString();
        this.races.get(id).setIsClosed(true);

        return outPut;
    }

    public void park(int id) {
        boolean isParticipant = false;

        for (Race race : this.races.values()) {
            if (!race.getIsClosed() && race.getParticipants().contains(this.cars.get(id))) {
                isParticipant = true;
                break;
            }
        }

        if (!isParticipant) {
            this.garage.addCar(this.cars.get(id));
        }
    }

    public void unpark(int id) {
        this.garage.removeCar(this.cars.get(id));
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.getParkedCars().forEach(car -> car.tune(tuneIndex, addOn));
    }
}