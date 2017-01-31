import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        LinkedHashMap<String, String> personEmail = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String person = command;
            String email = console.nextLine();

            String[] domainParts = email.split("@")[1].split("\\.");
            String domain = domainParts[domainParts.length - 1].toLowerCase();

            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                personEmail.put(person, email);
            }

            command = console.nextLine();
        }

        for (String person : personEmail.keySet()) {
            System.out.printf("%s -> %s%n", person, personEmail.get(person));
        }
    }
}