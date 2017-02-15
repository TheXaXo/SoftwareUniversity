import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder(reader.readLine());
        StringBuilder sequence = new StringBuilder(reader.readLine());

        while (input.indexOf(sequence.toString()) != -1 && input.lastIndexOf(sequence.toString()) != -1 &&
                input.indexOf(sequence.toString()) != input.lastIndexOf(sequence.toString())) {

            input.delete(input.indexOf(sequence.toString()), input.indexOf(sequence.toString()) + sequence.length());
            input.delete(input.lastIndexOf(sequence.toString()), input.lastIndexOf(sequence.toString()) + sequence.length());

            System.out.println("Shaked it.");

            sequence.delete(sequence.length() / 2, sequence.length() / 2 + 1);

            if (sequence.length() < 1) {
                break;
            }
        }

        System.out.println("No shake.");
        System.out.println(input);
    }
}