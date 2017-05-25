import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        if (capacity <= 0) {
            return;
        }

        String command = reader.readLine();

        StringBuilder output = new StringBuilder();

        ArrayDeque<String> bunkers = new ArrayDeque<>();

        HashMap<String, ArrayDeque<Integer>> bunkerWeapons = new HashMap<>();

        while (!command.equals("Bunker Revision")) {
            String[] tokens = command.split("\\s+");

            for (String token : tokens) {
                if (!isDigit(token)) {
                    bunkers.add(token);
                    bunkerWeapons.put(token, new ArrayDeque<>());
                } else {
                    int weaponCapacity = Integer.parseInt(token);

                    if (weaponCapacity <= 0) {
                        continue;
                    }

                    if (bunkers.size() == 1) {
                        if (weaponCapacity > capacity) {
                            continue;
                        } else {
                            while (capacity - bunkerWeapons.get(bunkers.peek()).stream().mapToInt(a -> a).sum() < weaponCapacity) {
                                bunkerWeapons.get(bunkers.peek()).remove();
                            }

                            bunkerWeapons.get(bunkers.peek()).add(weaponCapacity);
                        }
                    } else {
                        while (bunkers.size() != 1 && capacity - bunkerWeapons.get(bunkers.peek()).stream().mapToInt(a -> a).sum() < weaponCapacity) {
                            String removedBunker = bunkers.remove();

                            System.out.printf("%s -> ", removedBunker);

                            if (bunkerWeapons.get(removedBunker).isEmpty()) {
                                System.out.println("Empty");

                                bunkerWeapons.remove(removedBunker);
                                continue;
                            }

                            for (int weapon : bunkerWeapons.get(removedBunker)) {
                                output.append(weapon).append(", ");
                            }

                            String toPrint = output.substring(0, output.length() - 2);

                            System.out.println(toPrint);
                            output.setLength(0);
                            bunkerWeapons.remove(removedBunker);
                        }

                        if (bunkers.size() == 1) {
                            if (weaponCapacity > capacity) {
                                continue;
                            } else {
                                while (capacity - bunkerWeapons.get(bunkers.peek()).stream().mapToInt(a -> a).sum() < weaponCapacity) {
                                    bunkerWeapons.get(bunkers.peek()).remove();
                                }

                                bunkerWeapons.get(bunkers.peek()).add(weaponCapacity);
                            }
                        } else {
                            bunkerWeapons.get(bunkers.peek()).add(weaponCapacity);
                        }
                    }
                }
            }

            command = reader.readLine();
        }
    }

    private static boolean isDigit(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
