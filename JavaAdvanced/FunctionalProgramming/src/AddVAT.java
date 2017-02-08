import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] prices = reader.readLine().split(", ");

        UnaryOperator<Double> addVat = price -> price *= 1.2;

        System.out.println("Prices with VAT:");

        for (String price : prices) {
            double priceAsDouble = Double.parseDouble(price);

            System.out.println(String.format("%.2f", addVat.apply(priceAsDouble)).replace('.', ','));
        }
    }
}