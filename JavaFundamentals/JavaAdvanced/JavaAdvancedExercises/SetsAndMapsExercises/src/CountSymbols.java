import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        TreeMap<Character, Integer> symbolCount = new TreeMap<>();

        for (char c : input.toCharArray()) {
            if (!symbolCount.containsKey(c)) {
                symbolCount.put(c, 1);
            } else {
                symbolCount.put(c, symbolCount.get(c) + 1);
            }
        }

        for (char symbol : symbolCount.keySet()) {
            System.out.printf("%s: %d time/s%n", symbol, symbolCount.get(symbol));
        }
    }
}