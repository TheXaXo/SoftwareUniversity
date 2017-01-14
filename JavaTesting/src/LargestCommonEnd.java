import java.util.Scanner;

public class LargestCommonEnd {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] inputOne = console.nextLine().split("\\s");
        String[] inputTwo = console.nextLine().split("\\s");

        int frontCount = getEndCount(inputOne, inputTwo);

        String[] inputOneReversed = new String[inputOne.length];
        String[] inputTwoReversed = new String[inputTwo.length];

        int j = 0;
        for (int i = inputOne.length - 1; i >= 0; i--) {
            inputOneReversed[j] = inputOne[i];
            j++;
        }

        j = 0;
        for (int i = inputTwo.length - 1; i >= 0; i--) {
            inputTwoReversed[j] = inputTwo[i];
            j++;
        }

        int backCount = getEndCount(inputOneReversed, inputTwoReversed);

        System.out.println(Math.max(frontCount, backCount));
    }

    public static int getEndCount(String[] arrayOne, String[] arrayTwo) {
        int count = 0;

        for (int i = 0; i < Math.min(arrayOne.length, arrayTwo.length); i++) {
            if (arrayOne[i].equals(arrayTwo[i])) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}