import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!line.equals("END")) {
            String[] lineArgs = line.split("[?&]");

            LinkedHashMap<String, ArrayList<String>> pair = new LinkedHashMap<>();

            for (String arg : lineArgs) {
                String[] argSplit = arg.split("=");

                if (argSplit.length == 1) {
                    continue;
                }

                String key = argSplit[0].replaceAll("(%20|\\+)", " ").replaceAll("\\s+", " ").trim();
                String value = argSplit[1].replaceAll("(%20|\\+)", " ").replaceAll("\\s+", " ").trim();

                if (!pair.containsKey(key)) {
                    pair.put(key, new ArrayList<>());
                }

                pair.get(key).add(value);
            }

            for (String key : pair.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                for (String value : pair.get(key)) {
                    if (pair.get(key).indexOf(value) != pair.get(key).size() - 1) {
                        sb.append(value).append(", ");
                    } else {
                        sb.append(value).append("]");
                    }
                }

                System.out.printf("%s=%s", key, sb);
            }

            line = reader.readLine();
            System.out.println();
        }
    }
}