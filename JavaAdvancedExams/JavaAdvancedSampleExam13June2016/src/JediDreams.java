import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediDreams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Pattern p = Pattern.compile("[.\\s]([a-zA-Z]*[A-Z]+[a-zA-Z]*)\\(");

        HashMap<String, ArrayList<String>> methodInvoked = new HashMap<>();

        String lastAddedMethod = "";

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();

            Matcher m = p.matcher(line);

            while (m.find()) {
                String currentMatch = m.group(1);

                if (line.trim().startsWith("static")) {
                    lastAddedMethod = currentMatch;
                    methodInvoked.put(lastAddedMethod, new ArrayList<>());
                } else {
                    int index = line.indexOf(currentMatch);
                    String lineUntilMatch = line.substring(0, index);

                    if (lineUntilMatch.contains("new")) {
                        continue;
                    }

                    if (!lastAddedMethod.equals("") && methodInvoked.containsKey(lastAddedMethod)) {
                        methodInvoked.get(lastAddedMethod).add(currentMatch);
                    }
                }
            }
        }

        methodInvoked.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, ArrayList<String>>>comparingInt(pair -> pair.getValue().size())
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(pair -> {
                    System.out.printf("%s -> %d -> ", pair.getKey(), pair.getValue().size());

                    StringBuilder output = new StringBuilder();

                    if (pair.getValue().size() == 0) {
                        System.out.println("None");
                    } else {
                        pair.getValue().stream()
                                .sorted(String::compareTo)
                                .forEach(invokedMethod -> output.append(invokedMethod).append(", "));
                        System.out.println(output.substring(0, output.length() - 2));
                    }
                });
    }
}