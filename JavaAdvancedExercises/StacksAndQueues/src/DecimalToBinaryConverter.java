import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Byte> binaryNum = new ArrayDeque<>();

        while (number > 0) {
            byte reminder = (byte) (number % 2);
            number = number / 2;

            binaryNum.push(reminder);
        }

        while (!binaryNum.isEmpty()) {
            System.out.print(binaryNum.pop());
        }
    }
}