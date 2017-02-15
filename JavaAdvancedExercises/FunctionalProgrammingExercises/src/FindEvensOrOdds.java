import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.BiFunction;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArgs = reader.readLine().split(" ");

        int n = Integer.parseInt(inputArgs[0]);
        int m = Integer.parseInt(inputArgs[1]);

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = n; i <= m; i++) {
            numbers.add(i);
        }

        String type = reader.readLine();

        BiFunction<ArrayList<Integer>, String, ArrayList<Integer>> getEvensOrOdds = (allNumbers, wantedType) -> {
            ArrayList<Integer> numbersToReturn = new ArrayList<>();

            for (int number : allNumbers) {
                if (number % 2 == 0) {
                    if (wantedType.equals("even")) {
                        numbersToReturn.add(number);
                    }
                } else {
                    if (wantedType.equals("odd")) {
                        numbersToReturn.add(number);
                    }
                }
            }

            return numbersToReturn;
        };

        ArrayList<Integer> numbersToPrint = getEvensOrOdds.apply(numbers, type);

        for (int number : numbersToPrint) {
            System.out.print(number + " ");
        }
    }
}