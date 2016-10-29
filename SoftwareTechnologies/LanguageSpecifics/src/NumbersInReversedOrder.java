import java.util.Scanner;

public class NumbersInReversedOrder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String number = console.nextLine();

        System.out.println(Reverse(number));
    }
    public static String Reverse(String input){
        return new StringBuilder(input).reverse().toString();
    }
}