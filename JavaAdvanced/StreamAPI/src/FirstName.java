import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split(" ");
        HashSet<Character> chars = Arrays.stream(reader.readLine().split(" "))
                .map(c -> c.toLowerCase().charAt(0))
                .collect(Collectors.toCollection(HashSet::new));

        Optional<String> namesFiltered = Arrays.stream(names)
                .sorted()
                .filter(name -> chars.contains(name.toLowerCase().charAt(0)))
                .findFirst();

        if (namesFiltered.isPresent()) {
            System.out.println(namesFiltered.get());
        } else {
            System.out.println("No match");
        }
    }
}