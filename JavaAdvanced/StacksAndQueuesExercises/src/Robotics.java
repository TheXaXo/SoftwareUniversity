import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] split = console.nextLine().split(";");

        ArrayList<Robot> robots = new ArrayList<>();

        for (String s : split) {
            String[] sSplit = s.split("-");

            Robot robot = new Robot();

            robot.name = sSplit[0];
            robot.processingTime = Integer.parseInt(sSplit[1]);
            robot.isBusy = false;

            robots.add(robot);
        }

        if (robots.size() == 0) {
            return;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm:ss");
        LocalTime time = LocalTime.parse(console.nextLine(), dateTimeFormatter);

        String command = console.nextLine();

        ArrayDeque<String> products = new ArrayDeque<>();

        while (!command.equals("End")) {
            products.add(command);

            command = console.nextLine();
        }

        while (!products.isEmpty()) {
            time = time.plusSeconds(1);

            String product = products.remove();

            boolean hasBeenSentForProcessing = false;

            for (Robot r : robots) {
                if (r.isBusy) {
                    r.hasBeenProcessingFor++;

                    if (r.hasBeenProcessingFor >= r.processingTime) {
                        r.isBusy = false;
                        r.hasBeenProcessingFor = 0;
                    }
                }

                if (!r.isBusy && !hasBeenSentForProcessing) {
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", r.name, product, time.getHour(), time.getMinute(), time.getSecond());

                    hasBeenSentForProcessing = true;
                    r.isBusy = true;
                }
            }

            if (!hasBeenSentForProcessing) {
                products.add(product);
            }
        }
    }
}

class Robot {
    String name;
    int processingTime;
    boolean isBusy;
    int hasBeenProcessingFor = 0;
}