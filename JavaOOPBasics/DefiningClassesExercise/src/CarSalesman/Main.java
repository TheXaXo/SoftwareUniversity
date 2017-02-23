package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] engineTokens = reader.readLine().split(" ");

            String name = engineTokens[0];
            int power = Integer.parseInt(engineTokens[1]);

            Engine engine = new Engine(name, power);

            if (engineTokens.length > 2) {
                String element = engineTokens[2];

                if (checkIfIsNumber(element)) {
                    engine.setDisplacement(element);
                } else {
                    engine.setEfficiency(element);
                }
            }

            if (engineTokens.length > 3) {
                String element = engineTokens[3];

                if (checkIfIsNumber(element)) {
                    engine.setDisplacement(element);
                } else {
                    engine.setEfficiency(element);
                }
            }

            engines.add(engine);
        }

        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] carTokens = reader.readLine().split(" ");

            String model = carTokens[0];
            String engineName = carTokens[1];

            Car car = new Car(model);

            Optional<Engine> engineToPut = engines.stream().filter(eng -> eng.getModel().equals(engineName)).findFirst();

            if (engineToPut.isPresent()) {
                car.setEngine(engineToPut.get());
            }

            if (carTokens.length > 2) {
                String element = carTokens[2];

                if (checkIfIsNumber(element)) {
                    car.setWeight(element);
                } else {
                    car.setColor(element);
                }
            }

            if (carTokens.length > 3) {
                String element = carTokens[3];

                if (checkIfIsNumber(element)) {
                    car.setWeight(element);
                } else {
                    car.setColor(element);
                }
            }

            System.out.println(car);
        }
    }

    public static boolean checkIfIsNumber(String element) {
        try {
            Integer.parseInt(element);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}