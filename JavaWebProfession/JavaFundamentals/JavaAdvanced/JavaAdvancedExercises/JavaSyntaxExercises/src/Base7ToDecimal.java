import java.util.Scanner;

public class Base7ToDecimal {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String number = console.next();

        System.out.println(Integer.valueOf(number, 7));
    }
}