import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num1 = console.nextInt();
        double num2 = console.nextDouble();
        double num3 = console.nextDouble();

        String num1Hex = Integer.toHexString(num1).toUpperCase();
        String num1Binary = String.format("%10s", Integer.toBinaryString(num1)).replace(' ', '0');
        String num2Formatted = String.format("%.2f", num2);
        String num3Formatted = String.format("%.3f", num3);

        int firstColumnSpaces = 10 - num1Hex.length();
        int thirdColumnSpaces = 10 - num2Formatted.length();
        int fourthColumnSpaces = 10 - num3Formatted.length();

        System.out.printf("|%s%" + firstColumnSpaces + "s|%s|%" + thirdColumnSpaces + "s%s|%s%" + fourthColumnSpaces + "s|",
                num1Hex, " ", num1Binary, " ", num2Formatted, num3Formatted, " ");
    }
}