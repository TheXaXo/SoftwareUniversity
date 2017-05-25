package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLight[] possibleStates = TrafficLight.values();

        String[] lights = reader.readLine().split(" ");
        List<TrafficLight> lightsToUpdate = new ArrayList<>();

        for (String lightStr : lights) {
            lightsToUpdate.add(TrafficLight.valueOf(lightStr));
        }

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lightsToUpdate.size(); j++) {
                TrafficLight lightToUpdate = lightsToUpdate.get(j);

                lightToUpdate = possibleStates[(lightToUpdate.ordinal() + 1) % 3];
                lightsToUpdate.set(j, lightToUpdate);

                System.out.print(lightToUpdate + " ");
            }
            System.out.println();
        }
    }
}