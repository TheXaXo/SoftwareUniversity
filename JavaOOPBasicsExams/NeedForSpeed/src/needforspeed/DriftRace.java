package needforspeed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s - %d%n", this.getRoute(), this.getLength()));

        long[] prizes = new long[3];
        prizes[0] = ((long) this.getPrizePool() * 50) / 100;
        prizes[1] = ((long) this.getPrizePool() * 30) / 100;
        prizes[2] = ((long) this.getPrizePool() * 20) / 100;

        int position = 0;

        ArrayList<Car> winners = this.getParticipants().stream()
                .sorted(Comparator.comparingInt(Car::getSuspensionPerformance).reversed())
                .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));

        for (Car winner : winners) {
            out.append(String.format("%d. %s %s %dPP - $%d%n", position + 1,
                    winner.getBrand(), winner.getModel(), winner.getSuspensionPerformance(), prizes[position]));

            position++;
        }

        return out.toString();
    }
}