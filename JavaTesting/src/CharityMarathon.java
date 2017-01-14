import java.util.Scanner;

public class CharityMarathon {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int daysCount = Integer.parseInt(console.nextLine());
        int runners = Integer.parseInt(console.nextLine());
        int averageLaps = Integer.parseInt(console.nextLine());
        double lapLength = Double.parseDouble(console.nextLine()) / 1000;
        int capacity = Integer.parseInt(console.nextLine());
        double moneyPerKilometer = Double.parseDouble(console.nextLine());

        if (capacity * daysCount < runners) {
            runners = capacity * daysCount;
        }

        double totalDistance = averageLaps * lapLength * (long) runners;

        double totalMoneyRaised = totalDistance * moneyPerKilometer;

        System.out.printf("Money raised: %.2f%n", totalMoneyRaised);
    }
}