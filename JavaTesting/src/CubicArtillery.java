import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        String command = reader.readLine();

        ArrayDeque<Character> bunkers = new ArrayDeque<>();
        HashMap<Character, ArrayDeque<Integer>> bunkerCapacity = new HashMap<>();

        while (!command.equals("Bunker Revision")) {
            String[] inputArgs = command.split(" ");

            for (String arg : inputArgs) {
                if ((arg.charAt(0) >= 65 && arg.charAt(0) <= 90)
                        || (arg.charAt(0) >= 97 && arg.charAt(0) <= 122)) {

                    bunkers.add(arg.charAt(0));
                    bunkerCapacity.put(arg.charAt(0), new ArrayDeque<>());
                } else {
                    int weaponCapacity = Integer.parseInt(arg);

                    if (bunkers.size() == 1) {

                        if (capacity >= weaponCapacity) {
                            int currentCapacityLeft = capacity - bunkerCapacity.get(bunkers.peek()).stream()
                                    .mapToInt(a -> a)
                                    .sum();

                            while (currentCapacityLeft < weaponCapacity) {
                                bunkerCapacity.get(bunkers.peek()).remove();

                                currentCapacityLeft = capacity - bunkerCapacity.get(bunkers.peek()).stream()
                                        .mapToInt(a -> a)
                                        .sum();
                            }

                            bunkerCapacity.get(bunkers.peek()).add(weaponCapacity);
                        }
                    } else {
                        boolean canBeContained = false;

                        while (!canBeContained && bunkers.size() > 1) {
                            int currentCapacityLeft = capacity - bunkerCapacity.get(bunkers.peek()).stream()
                                    .mapToInt(a -> a)
                                    .sum();

                            if (currentCapacityLeft < weaponCapacity) {
                                char removedBunker = bunkers.remove();

                                ArrayDeque<Integer> currentItems = bunkerCapacity.get(removedBunker);

                                if (currentItems.size() == 0) {
                                    System.out.printf("%s -> Empty%n", removedBunker);
                                } else {
                                    StringBuilder sb = new StringBuilder();

                                    while (!currentItems.isEmpty()) {
                                        sb.append(currentItems.remove()).append(", ");
                                    }

                                    String output = sb.substring(0, sb.length() - 2);

                                    System.out.printf("%s -> %s%n", removedBunker, output);
                                }

                                bunkerCapacity.remove(removedBunker);
                            } else {
                                canBeContained = true;

                                bunkerCapacity.get(bunkers.peek()).add(weaponCapacity);
                            }
                        }
                    }
                }
            }

            command = reader.readLine();
        }
    }
}