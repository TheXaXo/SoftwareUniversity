package needforspeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        CarManager carManager = new CarManager();

        while (!command.equals("Cops Are Here")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "register":
                    carManager.register(Integer.parseInt(tokens[1]), tokens[2], tokens[3],
                            tokens[4], Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]));
                    break;

                case "check":
                    System.out.println(carManager.check(Integer.parseInt(tokens[1])));
                    break;

                case "open":
                    if (tokens.length == 6) {
                        carManager.open(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4],
                                Integer.parseInt(tokens[5]));
                    } else {
                        carManager.open(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4],
                                Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
                    }
                    break;

                case "participate":
                    carManager.participate(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;

                case "start":
                    System.out.print(carManager.start(Integer.parseInt(tokens[1])));
                    break;

                case "park":
                    carManager.park(Integer.parseInt(tokens[1]));
                    break;

                case "unpark":
                    carManager.unpark(Integer.parseInt(tokens[1]));
                    break;

                case "tune":
                    carManager.tune(Integer.parseInt(tokens[1]), tokens[2]);
                    break;
            }

            command = reader.readLine();
        }
    }
}