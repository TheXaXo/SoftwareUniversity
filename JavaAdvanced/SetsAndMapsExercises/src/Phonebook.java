import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        HashMap<String, String> nameNumber = new HashMap<>();

        while (!command.equals("search")) {
            String[] contactArgs = command.split("-");

            String name = contactArgs[0];
            String phoneNumber = contactArgs[1];

            nameNumber.put(name, phoneNumber);

            command = console.nextLine();
        }

        command = console.nextLine();

        while (!command.equals("stop")) {
            String pearsonToSearchFor = command;

            if (nameNumber.containsKey(pearsonToSearchFor)) {
                System.out.printf("%s -> %s%n", pearsonToSearchFor, nameNumber.get(pearsonToSearchFor));
            } else {
                System.out.printf("Contact %s does not exist.%n", pearsonToSearchFor);
            }

            command = console.nextLine();
        }
    }
}