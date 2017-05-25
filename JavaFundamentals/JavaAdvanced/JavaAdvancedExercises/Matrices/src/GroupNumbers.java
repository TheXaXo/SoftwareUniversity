import java.util.ArrayList;
import java.util.Scanner;

public class GroupNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(", ");

        ArrayList<ArrayList<Integer>> jagged = new ArrayList<>();

        jagged.add(0, new ArrayList<>());
        jagged.add(1, new ArrayList<>());
        jagged.add(2, new ArrayList<>());

        for (String number : input) {
            int numberInt = Integer.parseInt(number);
            int reminder = Math.abs(numberInt % 3);

            jagged.get(reminder).add(numberInt);
        }

        for (int row = 0; row < jagged.size(); row++) {
            for (int column = 0; column < jagged.get(row).size(); column++) {
                System.out.print(jagged.get(row).get(column) + " ");
            }
            System.out.println();
        }
    }
}