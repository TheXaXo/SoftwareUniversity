import java.util.Scanner;

public class EmployeeData {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String firstName = console.nextLine();
        String lastName = console.nextLine();
        int age = Integer.parseInt(console.nextLine());
        char gender = console.nextLine().charAt(0);
        long personalNumber = Long.parseLong((console.nextLine()));
        long employeeNumber = Long.parseLong((console.nextLine()));

        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Personal ID: " + personalNumber);
        System.out.println("Unique Employee number: " + employeeNumber);
    }
}