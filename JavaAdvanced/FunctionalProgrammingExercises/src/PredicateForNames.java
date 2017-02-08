import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int desiredLength = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");

        BiPredicate<String, Integer> checkName = (name, length) -> name.length() <= length;

        for (String name : names) {
            if (checkName.test(name, desiredLength)) {
                System.out.println(name);
            }
        }
    }
}