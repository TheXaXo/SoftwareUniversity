import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] elements = reader.readLine().split(" ");

            ArrayList<Integer> sequence = new ArrayList<>();

            for (String element : elements) {
                sequence.add(Integer.parseInt(element));
            }

            sequences.add(sequence);
        }

        ArrayList<Integer> seismicities = new ArrayList<>();

        while (!sequences.isEmpty()) {
            ArrayList<Integer> currentSequence = sequences.remove(0);

            if (currentSequence.isEmpty()) {
                continue;
            }

            if (currentSequence.size() == 1) {
                seismicities.add(currentSequence.get(0));
                continue;
            }

            int seismicity = currentSequence.get(0);
            seismicities.add(seismicity);

            for (int i = 1; i < currentSequence.size(); i++) {
                if (seismicity >= currentSequence.get(i)) {
                    currentSequence.remove(i);

                    i--;
                } else {
                    currentSequence.remove(currentSequence.indexOf(seismicity));

                    sequences.add(currentSequence);
                    break;
                }
            }
        }

        System.out.println(seismicities.size());
        for (int number : seismicities) {
            System.out.print(number + " ");
        }
    }
}