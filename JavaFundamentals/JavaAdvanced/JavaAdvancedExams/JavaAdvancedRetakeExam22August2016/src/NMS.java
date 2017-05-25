import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        StringBuilder sb = new StringBuilder();

        while (!command.equals("---NMS SEND---")) {
            sb.append(command);

            command = reader.readLine();
        }

        String delimiter = reader.readLine();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (output.length() == 0) {
                output.append(sb.charAt(i));
                continue;
            }

            if (Character.toLowerCase(sb.charAt(i - 1)) <= Character.toLowerCase(sb.charAt(i)) || output.toString().endsWith(delimiter)) {
                output.append(sb.charAt(i));
            } else {
                output.append(delimiter);
                i--;
            }
        }

        System.out.println(output);
    }
}