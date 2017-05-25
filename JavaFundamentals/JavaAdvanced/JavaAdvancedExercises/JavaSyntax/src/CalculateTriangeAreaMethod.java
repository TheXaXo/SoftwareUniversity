import java.util.Scanner;

public class CalculateTriangeAreaMethod {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double base = console.nextDouble();
        double height = console.nextDouble();

        System.out.printf("Area = %.2f", calculateArea(base, height));
    }

    public static double calculateArea(double base, double height) {
        return base * height / 2;
    }
}