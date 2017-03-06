package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        double carFuelQuantity = Double.parseDouble(tokens[1]);
        double carFuelConsumption = Double.parseDouble(tokens[2]);

        Car car = new Car(carFuelQuantity, carFuelConsumption);

        tokens = reader.readLine().split(" ");

        double truckFuelQuantity = Double.parseDouble(tokens[1]);
        double truckFuelConsumption = Double.parseDouble(tokens[2]);

        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int n = Integer.parseInt(reader.readLine());

        DecimalFormat format = new DecimalFormat("0.######");

        for (int i = 0; i < n; i++) {
            tokens = reader.readLine().split(" ");
            String command = tokens[0];
            String vehicleType = tokens[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);

                    try {
                        if (vehicleType.equals("Car")) {
                            car.drive(distance);
                            System.out.printf("Car travelled %s km%n", format.format(distance));
                        } else {
                            truck.drive(distance);
                            System.out.printf("Truck travelled %s km%n", format.format(distance));
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Refuel":
                    double fuel = Double.parseDouble(tokens[2]);

                    if (vehicleType.equals("Car")) {
                        car.refuel(fuel);
                    } else {
                        truck.refuel(fuel);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}