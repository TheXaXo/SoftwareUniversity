import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int distance = Integer.parseInt(console.nextLine());
        String timeOfDay = console.nextLine();

        double price = 0;

        if (distance < 20) {
            price += 0.7;

            if (timeOfDay.equals("day")) {
                price = price + distance * 0.79;
            } else {
                price = price + distance * 0.9;
            }
        } else if (distance < 100) {
            price = distance * 0.09;
        } else {
            price = distance * 0.06;
        }

        System.out.printf("%.2f", price);
    }
}