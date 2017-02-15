import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double a = console.nextDouble();
        double b = console.nextDouble();

        System.out.printf("%.2f", a * b);
    }
}