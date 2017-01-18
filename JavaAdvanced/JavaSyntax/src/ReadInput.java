import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String wordOne = console.next();
        String wordTwo = console.next();

        int numInt = console.nextInt();
        double numDoubleOne = console.nextDouble();
        double numDoubleTwo = console.nextDouble();

        String wordThree = console.next();

        int sum = (int) (numInt + numDoubleOne + numDoubleTwo);

        System.out.printf("%s %s %s %d", wordOne, wordTwo, wordThree, sum);
    }
}