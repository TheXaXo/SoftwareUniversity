import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        TreeSet<String> guests = new TreeSet<>();

        while (!command.equals("PARTY")) {
            guests.add(command);

            command = console.nextLine();
        }

        command = console.nextLine();

        while (!command.equals("END")) {
            if (guests.contains(command)) {
                guests.remove(command);
            }

            command = console.nextLine();
        }

        System.out.println(guests.size());

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}