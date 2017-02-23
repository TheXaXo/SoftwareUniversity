package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            Car car = new Car(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                    tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6]), Double.parseDouble(tokens[7]),
                    Integer.parseInt(tokens[8]), Double.parseDouble(tokens[9]), Integer.parseInt(tokens[10]),
                    Double.parseDouble(tokens[11]), Integer.parseInt(tokens[12]));

            cars.add(car);
        }

        String command = reader.readLine();

        switch (command) {
            case "fragile":
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals("fragile") &&
                                car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
                        .forEach(car -> System.out.println(car.getModel()));
                break;

            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals("flamable") &&
                                car.getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
        }
    }
}