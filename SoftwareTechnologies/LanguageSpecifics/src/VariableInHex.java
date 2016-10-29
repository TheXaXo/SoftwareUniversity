import java.util.Scanner;

public class VariableInHex {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String numberAsString = console.nextLine().substring(2);
        int numberInHex = Integer.parseInt(numberAsString, 16);

        System.out.println(numberInHex);
    }
}