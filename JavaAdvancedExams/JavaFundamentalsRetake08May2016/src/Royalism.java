import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] people = reader.readLine().split(" ");

        ArrayList<String> royalists = new ArrayList<>();
        ArrayList<String> nonRoyalists = new ArrayList<>();

        for (String person : people) {
            int personSum = 0;

            for (char c : person.toCharArray()) {
                personSum += c;

                while (personSum > 26) {
                    personSum -= 26;
                }
            }

            if (personSum == 18) {
                royalists.add(person);
            } else {
                nonRoyalists.add(person);
            }
        }

        if (royalists.size() >= nonRoyalists.size()) {
            System.out.printf("Royalists - %d%n", royalists.size());
            System.out.println(String.join("\r\n", royalists));
            System.out.println("All hail Royal!");
        } else {
            System.out.println(String.join("\r\n", nonRoyalists));
            System.out.println("Royalism, Declined!");
        }
    }
}