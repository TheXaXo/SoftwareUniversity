import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FoldAndSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine().split("\\s"))
                .mapToInt(a -> Integer.parseInt(a))
                .toArray();

        int k = input.length / 4;

        int[] leftPart = Arrays.copyOfRange(input, 0, k);
        int[] rightPart = Arrays.copyOfRange(input, 3 * k, 4 * k);

        int[] leftPartReversed = new int[leftPart.length];
        int[] rightPartReversed = new int[rightPart.length];

        int index = 0;
        for (int i = leftPart.length - 1; i >= 0; i--) {
            leftPartReversed[index] = leftPart[i];
            index++;
        }

        index = 0;
        for (int i = rightPart.length - 1; i >= 0; i--) {
            rightPartReversed[index] = rightPart[i];
            index++;
        }

        int[] topPart = Stream.concat(Arrays.stream(leftPartReversed).boxed(), Arrays.stream(rightPartReversed).boxed())
                .mapToInt(a -> a)
                .toArray();

        int[] bottomPart = Arrays.copyOfRange(input, k, 3 * k);

        for (int i = 0; i < 2 * k; i++) {
            System.out.print(topPart[i] + bottomPart[i] + " ");
        }
    }
}