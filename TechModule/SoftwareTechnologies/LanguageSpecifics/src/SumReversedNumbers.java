import java.util.Scanner;

public class SumReversedNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");
        int[] inputAsNumbersReversed = new int[input.length];

        for (int i = 0; i < input.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(input[i]);
            sb.reverse();

            inputAsNumbersReversed[i] = Integer.parseInt(sb.toString());
        }

        int sum = 0;
        for (int number : inputAsNumbersReversed){
            sum += number;
        }

        System.out.println(sum);
    }
}
