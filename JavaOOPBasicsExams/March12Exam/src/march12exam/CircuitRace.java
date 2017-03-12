package march12exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.setLaps(laps);
    }

    public int getLaps() {
        return this.laps;
    }

    private void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s - %d%n", this.getRoute(), this.getLength() * this.getLaps()));

        int[] prizes = new int[4];
        prizes[0] = (this.getPrizePool() * 40) / 100;
        prizes[1] = (this.getPrizePool() * 30) / 100;
        prizes[2] = (this.getPrizePool() * 20) / 100;
        prizes[3] = (this.getPrizePool() * 10) / 100;

        int position = 0;

        for (int i = 0; i < this.getLaps(); i++) {
            for (Car participant : this.getParticipants()) {
                participant.setDurability(participant.getDurability() - (this.getLength() * this.getLength()));
            }
        }

        ArrayList<Car> winners = this.getParticipants().stream()
                .sorted(Comparator.comparingInt(Car::getOverallPerformance).reversed())
                .limit(4)
                .collect(Collectors.toCollection(ArrayList::new));

        for (Car winner : winners) {
            out.append(String.format("%d. %s %s %dPP - $%d%n", position + 1,
                    winner.getBrand(), winner.getModel(), winner.getOverallPerformance(), prizes[position]));

            position++;
        }

        return out.toString();
    }
}
