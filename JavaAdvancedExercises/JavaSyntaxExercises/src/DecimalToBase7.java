import java.util.Scanner;

public class DecimalToBase7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = console.nextInt();

        System.out.println(Integer.toString(number, 7));
    }
}