import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CubicRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int dimension = Integer.parseInt(reader.readLine());

        long[][][] cube = new long[dimension][dimension][dimension];

        String command = reader.readLine();

        while (!command.equals("Analyze")) {
            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int x = tokens[0];
            int y = tokens[1];
            int z = tokens[2];
            int cells = tokens[3];

            if (cells < 0) {
                continue;
            }

            if (y >= 0 && y < cube.length && x >= 0 && x < cube[y].length && z >= 0 && z < cube[y][x].length) {
                cube[y][x][z] += (long) cells;
            }

            command = reader.readLine();
        }

        int emptyCellsCount = 0;
        long sum = 0;

        for (int y = 0; y < cube.length; y++) {
            for (int x = 0; x < cube[y].length; x++) {
                for (int z = 0; z < cube[y][x].length; z++) {
                    if (cube[y][x][z] == 0) {
                        emptyCellsCount++;
                    }

                    sum += cube[y][x][z];
                }
            }
        }

        System.out.println(sum);
        System.out.println(emptyCellsCount);
    }
}