package hash_tables_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Phonebook {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomHashDictionary<String, String> personNumber = new CustomHashDictionary<>();
        String line = reader.readLine();

        while (!line.equals("search")) {
            String[] split = line.split("-");
            String person = split[0];
            String number = split[1];

            personNumber.put(person, number);

            line = reader.readLine();
        }

        line = reader.readLine();

        while (!line.equals("end")) {
            if (!personNumber.containsKey(line)) {
                System.out.printf("Contact %s does not exist.\n", line);
            } else {
                System.out.printf("%s -> %s\n", line, personNumber.get(line));
            }

            line = reader.readLine();
        }
    }
}