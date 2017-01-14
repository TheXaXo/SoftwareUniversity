import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnduranceRally {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] drivers = console.nextLine().split("\\s");
        ArrayList<Double> zonesInput = Arrays.stream(console.nextLine().split("\\s"))
                .map(a -> a.replace(',', '.'))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> checkpointsIndex = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Double> checkpointsFuel = new ArrayList<>();

        for (int i = 0; i < zonesInput.size(); i++) {
            if (checkpointsIndex.contains(i)) {
                checkpointsFuel.add(zonesInput.get(i));
            }
        }

        for (String driver : drivers) {
            double driverFuel = driver.charAt(0);
            boolean hasNoFuelLeft = false;
            int zoneReachedIndex = 0;

            for (Double zone : zonesInput) {
                if (checkpointsFuel.contains(zone)) {
                    driverFuel += zone;
                } else {
                    driverFuel -= zone;

                    if (driverFuel <= 0) {
                        hasNoFuelLeft = true;
                        zoneReachedIndex = zonesInput.indexOf(zone);
                        break;
                    }
                }
            }

            if (hasNoFuelLeft) {
                System.out.printf("%s - reached %d%n", driver, zoneReachedIndex);
            } else {
                System.out.printf("%s - fuel left %.2f%n", driver, driverFuel);
            }
        }
    }
}