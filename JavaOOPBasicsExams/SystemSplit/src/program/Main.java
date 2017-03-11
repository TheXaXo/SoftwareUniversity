package program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TheSystem theSystem = new TheSystem();
        TheDump theDump = new TheDump(theSystem);

        String command = reader.readLine();

        while (!command.equals("System Split")) {
            String[] tokens = Arrays.stream(command.split("[,() ]")).filter(a -> !a.isEmpty()).toArray(String[]::new);

            switch (tokens[0]) {
                case "RegisterPowerHardware":
                    theSystem.registerPowerHardware(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;

                case "RegisterHeavyHardware":
                    theSystem.registerHeavyHardware(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;

                case "RegisterExpressSoftware":
                    theSystem.registerExpressSoftware(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                    break;

                case "RegisterLightSoftware":
                    theSystem.registerLightSoftware(tokens[1], tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                    break;

                case "ReleaseSoftwareComponent":
                    theSystem.releaseSoftwareComponent(tokens[1], tokens[2]);
                    break;

                case "Analyze":
                    System.out.print(theSystem.analyze());
                    break;

                case "Dump":
                    theDump.dump(tokens[1]);
                    break;

                case "Restore":
                    theDump.restore(tokens[1]);
                    break;

                case "Destroy":
                    theDump.destroy(tokens[1]);
                    break;

                case "DumpAnalyze":
                    System.out.println(theDump.dumpAnalyze());
                    break;
            }

            command = reader.readLine();
        }

        System.out.print(theSystem.split());
    }
}