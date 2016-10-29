import java.util.Scanner;

public class FoldAndSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputAsString = console.nextLine().split(" ");
        int[] input = new int[inputAsString.length];

        for (int i = 0; i < input.length; i++){
            input[i] = Integer.parseInt(inputAsString[i]);
        }

        int k = input.length / 4;

        int[] leftPart = new int[k];
        int count = 0;
        for (int i = k - 1; i >= 0; i--){
            leftPart[count] = input[i];
            count++;
        }

        int[] middlePart = new int[2 * k];
        count = 0;
        for (int i = k; i < 3 * k; i++){
            middlePart[count] = input[i];
            count++;
        }

        int[] rightPart = new int[k];
        count = 0;
        for (int i = 4 * k - 1; i >= 3 * k; i--)
        {
            rightPart[count] = input[i];
            count++;
        }

        int[] topPart = new int[2 * k];
        for (int i = 0; i < leftPart.length; i++){
            topPart[i] = leftPart[i];
        }
        count = k;
        for (int i = 0; i < rightPart.length; i++) {
            topPart[k] = rightPart[i];
            k++;
        }

        StringBuilder output = new StringBuilder();
        int element = 0;
        for (int i = 0; i < middlePart.length; i++)
        {
            element = middlePart[i] + topPart[i];
            output.append(element + " ");
        }

        System.out.println(output);
    }
}