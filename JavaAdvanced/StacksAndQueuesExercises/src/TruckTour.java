import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        HashMap<Integer, Long> indexFuel = new LinkedHashMap<>();
        HashMap<Integer, Long> indexDistance = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = console.nextLine().split("\\s");

            indexFuel.put(i, Long.parseLong(split[0]));
            indexDistance.put(i, Long.parseLong(split[1]));

            queue.add(i);
        }

        boolean hasMadeCircle = false;
        boolean firstStop = true;
        int fuel = 0;
        int startedIndex = 0;

        while (!hasMadeCircle) {
            int index = queue.remove();

            if (firstStop) {
                startedIndex = index;
            } else {
                if (startedIndex == index) {
                    hasMadeCircle = true;
                }
            }

            queue.add(index);

            fuel += indexFuel.get(index);
            long distanceToTravel = indexDistance.get(index);

            fuel -= distanceToTravel;

            firstStop = false;

            if (fuel < 0) {
                firstStop = true;
                fuel = 0;
            }
        }

        System.out.println(startedIndex);
    }
}