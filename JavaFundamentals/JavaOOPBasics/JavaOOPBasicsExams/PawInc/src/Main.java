import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AnimalCenterManager animalCenterManager = new AnimalCenterManager();

        String command = reader.readLine();

        while (!command.equals("Paw Paw Pawah")) {
            String[] tokens = command.split(" \\| ");

            switch (tokens[0]) {
                case "RegisterCleansingCenter":
                    animalCenterManager.registerCleansingCenter(tokens[1]);
                    break;

                case "RegisterAdoptionCenter":
                    animalCenterManager.registerAdoptionCenter(tokens[1]);
                    break;

                case "RegisterDog":
                    animalCenterManager.registerDog(tokens[1], Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]), tokens[4]);
                    break;

                case "RegisterCat":
                    animalCenterManager.registerCat(tokens[1], Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]), tokens[4]);
                    break;

                case "SendForCleansing":
                    animalCenterManager.sendForCleansing(tokens[1], tokens[2]);
                    break;

                case "Cleanse":
                    animalCenterManager.cleanse(tokens[1]);
                    break;

                case "Adopt":
                    animalCenterManager.adopt(tokens[1]);
                    break;

                case "RegisterCastrationCenter":
                    animalCenterManager.registerCastrarionCenter(tokens[1]);
                    break;

                case "SendForCastration":
                    animalCenterManager.sendForCastration(tokens[1], tokens[2]);
                    break;

                case "Castrate":
                    animalCenterManager.castrate(tokens[1]);
                    break;

                case "CastrationStatistics":
                    animalCenterManager.castrationStatistics();
                    break;
            }

            command = reader.readLine();
        }

        animalCenterManager.printStatistics();
    }
}