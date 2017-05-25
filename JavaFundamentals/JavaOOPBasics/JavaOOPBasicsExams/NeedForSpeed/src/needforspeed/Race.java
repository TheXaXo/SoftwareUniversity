package needforspeed;

import java.util.*;

public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private ArrayList<Car> participants;
    private boolean isClosed;

    public Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.setParticipants(new ArrayList<>());
    }

    public int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return this.route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return this.prizePool;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    private void setParticipants(ArrayList<Car> participants) {
        this.participants = participants;
    }

    public void setIsClosed(boolean status) {
        this.isClosed = status;
    }

    public boolean getIsClosed() {
        return this.isClosed;
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }
}
