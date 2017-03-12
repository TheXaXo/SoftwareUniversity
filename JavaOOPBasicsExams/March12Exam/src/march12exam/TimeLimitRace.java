package march12exam;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.setGoldTime(goldTime);
    }

    public int getGoldTime() {
        return this.goldTime;
    }

    private void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String earnedMedal;

        int timePerformance = this.getParticipants().get(0).getTimePerformance(this);
        int moneyEarned;

        if (timePerformance <= this.getGoldTime()) {
            earnedMedal = "Gold";
            moneyEarned = this.getPrizePool();
        } else if (timePerformance <= this.getGoldTime() + 15) {
            earnedMedal = "Silver";
            moneyEarned = (int) (this.getPrizePool() * 0.5);
        } else {
            earnedMedal = "Bronze";
            moneyEarned = (int) (this.getPrizePool() * 0.3);
        }

        sb.append(String.format("%s - %d%n", this.getRoute(), this.getLength()));
        sb.append(String.format("%s %s - %d s.%n", this.getParticipants().get(0).getBrand(),
                this.getParticipants().get(0).getModel(), this.getParticipants().get(0).getTimePerformance(this)));
        sb.append(String.format("%s Time, $%d.%n", earnedMedal, moneyEarned));

        return sb.toString();
    }

    @Override
    public void addParticipant(Car car) {
        if (this.getParticipants().isEmpty()) {
            super.addParticipant(car);
        }
    }
}