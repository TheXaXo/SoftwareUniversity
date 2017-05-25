package MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> soldiers = new ArrayList<>();
        Map<Integer, Soldier> privates = new HashMap<>();

        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Private":
                    Soldier _private = new Private
                            (Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    soldiers.add(_private);
                    privates.put(Integer.parseInt(tokens[1]), _private);

                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneral
                            (Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));

                    for (int i = 5; i < tokens.length; i++) {
                        int privateId = Integer.parseInt(tokens[i]);

                        leutenantGeneral.addPrivate(privates.get(privateId));
                    }

                    soldiers.add(leutenantGeneral);
                    privates.put(Integer.parseInt(tokens[1]), leutenantGeneral);

                    break;
                case "Engineer":
                    Engineer engineer;

                    try {
                        engineer = new Engineer
                                (Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5]);
                    } catch (IllegalArgumentException ex) {
                        break;
                    }

                    for (int i = 6; i < tokens.length - 1; i += 2) {
                        String partName = tokens[i];
                        int repairHours = Integer.parseInt(tokens[i + 1]);

                        Repair repair = new Repair(partName, repairHours);

                        engineer.addRepair(repair);
                    }

                    soldiers.add(engineer);
                    privates.put(Integer.parseInt(tokens[1]), engineer);

                    break;
                case "Commando":
                    Commando commando;

                    try {
                        commando = new Commando
                                (Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5]);
                    } catch (IllegalArgumentException ex) {
                        break;
                    }

                    for (int i = 6; i < tokens.length - 1; i += 2) {
                        String missionCodeName = tokens[i];
                        String missionState = tokens[i + 1];

                        try {
                            Mission mission = new Mission(missionCodeName, missionState);
                            commando.addMission(mission);
                        } catch (IllegalArgumentException ex) {
                            //Do nothing :)
                        }
                    }

                    soldiers.add(commando);
                    privates.put(Integer.parseInt(tokens[1]), commando);

                    break;
                case "Spy":
                    Soldier spy = new Spy
                            (Integer.parseInt(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));

                    soldiers.add(spy);

                    break;
            }

            command = reader.readLine();
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier);
        }
    }
}