import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double quantity = console.nextDouble();

        BigDecimal price = new BigDecimal(quantity * 1.2);
        BigDecimal rate = new BigDecimal(4210500000000L);
        price = price.multiply(rate);

        System.out.printf("%.2f marks", price);
    }
}
