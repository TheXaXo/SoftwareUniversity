package dependencyInversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PrimitiveCalculator calculator = new PrimitiveCalculator();

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "mode":
                    calculator.changeStrategy(tokens[1].charAt(0));
                    break;

                default:
                    System.out.println(calculator.performCalculation(
                            Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
                    break;
            }

            command = reader.readLine();
        }
    }
}