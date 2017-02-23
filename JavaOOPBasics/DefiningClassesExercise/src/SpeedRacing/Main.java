package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double distanceTravelled = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, distanceTravelled);
            cars.add(car);
        }

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            String modelToDrive = tokens[1];
            int kilometersToDrive = Integer.parseInt(tokens[2]);

            Optional<Car> carBeingDriven = cars.stream().filter(car -> car.getModel().equals(modelToDrive)).findFirst();

            if (carBeingDriven.isPresent()) {
                try {
                    carBeingDriven.get().move(kilometersToDrive);
                } catch (IllegalStateException ex) {
                    System.out.println("Insufficient fuel for the drive");
                }
            }

            command = reader.readLine();
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %.0f%n", car.getModel(), car.getFuelAmount(), car.getDistanceTravelled());
        }
    }
}