import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        HashSet<String> cars = new HashSet<>();

        while (!command.equals("END")) {
            String[] split = command.split(", ");

            String direction = split[0];
            String carNumber = split[1];

            if (direction.equals("IN")) {
                cars.add(carNumber);
            } else {
                cars.remove(carNumber);
            }

            command = console.nextLine();
        }

        for (String car : cars) {
            System.out.println(car);
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
    }
}