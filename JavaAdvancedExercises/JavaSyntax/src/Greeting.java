import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstName = console.nextLine();
        String lastName = console.nextLine();

        if (firstName.length() == 0) {
            firstName = "*****";
        }

        if (lastName.length() == 0) {
            lastName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, lastName);
    }
}