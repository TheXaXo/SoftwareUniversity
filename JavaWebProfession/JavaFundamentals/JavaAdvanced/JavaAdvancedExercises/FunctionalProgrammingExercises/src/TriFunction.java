import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split(" ");

        for (String name : names) {
            int nameSum = 0;

            for (char c : name.toCharArray()) {
                nameSum += c;
            }

            if (nameSum >= n) {
                System.out.println(name);
                return;
            }
        }
    }
}
