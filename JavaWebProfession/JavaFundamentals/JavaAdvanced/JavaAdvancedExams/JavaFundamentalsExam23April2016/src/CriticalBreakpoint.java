import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class CriticalBreakpoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        long criticalRatio = 0;

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        int i = 0;

        while (!command.equals("Break it.")) {
            String[] tokens = command.split(" ");

            int x1 = Integer.parseInt(tokens[0]);
            int y1 = Integer.parseInt(tokens[1]);
            int x2 = Integer.parseInt(tokens[2]);
            int y2 = Integer.parseInt(tokens[3]);

            long currentRatio = calculateCriticalRatio(x1, y1, x2, y2);
            if (criticalRatio == 0 && currentRatio != 0) {
                criticalRatio = currentRatio;
            }

            if (currentRatio != 0 && criticalRatio != 0 && currentRatio != criticalRatio) {
                System.out.println("Critical breakpoint does not exist.");
                return;
            }

            lines.add(new ArrayList<>());
            lines.get(i).add(x1);
            lines.get(i).add(y1);
            lines.get(i).add(x2);
            lines.get(i).add(y2);

            command = reader.readLine();
            i++;
        }

        for (ArrayList<Integer> line : lines) {
            System.out.println("Line: " + line);
        }

        BigInteger value = new BigInteger(Long.toString(criticalRatio));
        value = value.pow(lines.size());

        BigInteger result = value.remainder(new BigInteger(Integer.toString(lines.size())));
        System.out.println("Critical Breakpoint: " + result.toString());
    }

    public static long calculateCriticalRatio(int x1, int y1, int x2, int y2) {
        return Math.abs(((long) x2 + (long) y2) - ((long) x1 + (long) y1));
    }
}