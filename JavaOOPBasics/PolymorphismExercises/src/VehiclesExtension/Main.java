package VehiclesExtension;

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
        double carTankCapacity = Double.parseDouble(tokens[3]);

        Car car;

        try {
            car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        tokens = reader.readLine().split(" ");

        double truckFuelQuantity = Double.parseDouble(tokens[1]);
        double truckFuelConsumption = Double.parseDouble(tokens[2]);
        double truckTankCapacity = Double.parseDouble(tokens[3]);

        Truck truck;

        try {
            truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        Bus bus;

        tokens = reader.readLine().split(" ");

        double busFuelQuantity = Double.parseDouble(tokens[1]);
        double busFuelConsumption = Double.parseDouble(tokens[2]);
        double busTankCapacity = Double.parseDouble(tokens[3]);

        try {
            bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        int n = Integer.parseInt(reader.readLine());

        DecimalFormat format = new DecimalFormat("0.######");

        for (int i = 0; i < n; i++) {
            tokens = reader.readLine().split(" ");
            String command = tokens[0];
            String vehicleType = tokens[1];

            try {
                switch (command) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);

                        if (vehicleType.equals("Car")) {
                            car.drive(distance);
                            System.out.printf("Car travelled %s km%n", format.format(distance));
                        } else if (vehicleType.equals("Truck")) {
                            truck.drive(distance);
                            System.out.printf("Truck travelled %s km%n", format.format(distance));
                        } else {
                            bus.drive(distance);
                            System.out.printf("Bus travelled %s km%n", format.format(distance));
                        }
                        break;

                    case "Refuel":
                        double fuel = Double.parseDouble(tokens[2]);

                        if (vehicleType.equals("Car")) {
                            car.refuel(fuel);
                        } else if (vehicleType.equals("Truck")) {
                            truck.refuel(fuel);
                        } else {
                            bus.refuel(fuel);
                        }
                        break;

                    case "DriveEmpty":
                        distance = Double.parseDouble(tokens[2]);

                        bus.driveEmpty(distance);
                        break;

                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}