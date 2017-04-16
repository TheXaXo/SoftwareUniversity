package kingsGambit;

import kingsGambit.events.KillEvent;
import kingsGambit.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Subject king = new King(reader.readLine());

        String[] royalGuardsNames = reader.readLine().split(" ");
        String[] footmenNames = reader.readLine().split(" ");

        Map<String, Observer> personObservers = new LinkedHashMap<>();

        for (String name : royalGuardsNames) {
            Observer royalGuard = new RoyalGuard(name);
            personObservers.put(name, royalGuard);
            king.addObserver(royalGuard);
        }

        for (String name : footmenNames) {
            Observer footman = new Footman(name);
            personObservers.put(name, footman);
            king.addObserver(footman);
        }

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Attack":
                    king.notifyObservers();
                    break;

                case "Kill":
                    Observer observer = personObservers.get(tokens[1]);

                    KillEvent event = new KillEvent();
                    event.executeEvent(observer, king);
                    break;
            }

            command = reader.readLine();
        }
    }
}