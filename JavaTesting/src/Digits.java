import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
        int secondDigit = Integer.parseInt(Integer.toString(number).substring(1, 2));
        int thirdDigit = Integer.parseInt(Integer.toString(number).substring(2));

        int rows = firstDigit + secondDigit;
        int columns = firstDigit + thirdDigit;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (number % 5 == 0) {
                    number = number - firstDigit;
                } else if (number % 3 == 0) {
                    number = number - secondDigit;
                } else {
                    number = number + thirdDigit;
                }

                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}