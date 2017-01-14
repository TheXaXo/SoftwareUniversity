import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SinoTheWalker {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime timeOfLeaving = LocalTime.parse(console.nextLine(), f);

        int steps = Integer.parseInt(console.nextLine());
        int secondsPerStep = Integer.parseInt(console.nextLine());

        timeOfLeaving = timeOfLeaving.plusSeconds((long) steps * secondsPerStep);

        System.out.printf("Time Arrival: %02d:%02d:%02d",
                timeOfLeaving.getHour(), timeOfLeaving.getMinute(), timeOfLeaving.getSecond());
    }
}