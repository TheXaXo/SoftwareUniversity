import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehiclePark {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<String> vehicles = Arrays.stream(console.nextLine().split("\\s"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = console.nextLine();

        int vehilesSold = 0;

        while (!command.equals("End of customers!")) {
            String[] split = command.split("\\s");

            String wantedType = split[0];
            int wantedSeats = Integer.parseInt(split[2]);

            boolean hasBeenFound = false;

            for (int i = 0; i < vehicles.size(); i++) {
                String type = Character.toString(vehicles.get(i).charAt(0));
                int seats = Integer.parseInt(vehicles.get(i).substring(1));

                if (type.equals("b") && wantedType.equals("Bus") && wantedSeats == seats) {
                    hasBeenFound = true;
                } else if (type.equals("c") && wantedType.equals("Car") && wantedSeats == seats) {
                    hasBeenFound = true;
                } else if (type.equals("v") && wantedType.equals("Van") && wantedSeats == seats) {
                    hasBeenFound = true;
                }

                if (hasBeenFound) {
                    vehilesSold++;
                    vehicles.remove(vehicles.get(i));

                    System.out.printf("Yes, sold for %d$%n", type.charAt(0) * seats);
                    break;
                } else if (i == vehicles.size() - 1) {
                    System.out.println("No");
                }
            }

            command = console.nextLine();
        }

        System.out.println("Vehicles left: " + String.join(", ", vehicles));
        System.out.printf("Vehicles sold: %d%n", vehilesSold);
    }
}