import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());
        String hex = Integer.toString(number, 16).toUpperCase();
        String binary = Integer.toString(number, 2);

        System.out.println(hex);
        System.out.println(binary);
    }
}