import java.util.Scanner;

public class Loan {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Въведете сума:");
        double sum = Double.parseDouble(console.nextLine());

        System.out.println("Въведете лихва (%):");
        double interest = Double.parseDouble(console.nextLine());

        System.out.println("Период за изплащане на заема (месеци):");
        int period = Integer.parseInt(console.nextLine());

        System.out.println("Начална такса (y/n):");
        String firstTax = console.nextLine();

        double principal = sum / period;
        double sumToBePaid = 0;

        for (int i = 0; i < period; i++) {
            double tax = (sum * interest / 100) / 12;

            sumToBePaid = sumToBePaid + tax + principal;

            sum -= principal;
        }

        if (firstTax.equals("y")) {
            System.out.println("Въведете размера на първоначалната такса:");
            sumToBePaid += Double.parseDouble(console.nextLine());
        }

        System.out.printf("Сумата, която трябва да заплатите след %d месеца е %.2f лева.",
                period, sumToBePaid);
    }
}