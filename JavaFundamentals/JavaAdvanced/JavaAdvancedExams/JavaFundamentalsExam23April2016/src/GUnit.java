import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+)");

        String command = reader.readLine();

        HashMap<String, HashMap<String, HashSet<String>>> classMethods = new HashMap<>();

        while (!command.equals("It's testing time!")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = reader.readLine();
                continue;
            }

            String theClass = m.group(1);
            String method = m.group(2);
            String test = m.group(3);

            if (!classMethods.containsKey(theClass)) {
                classMethods.put(theClass, new HashMap<>());
            }

            if (!classMethods.get(theClass).containsKey(method)) {
                classMethods.get(theClass).put(method, new HashSet<>());
            }

            classMethods.get(theClass).get(method).add(test);

            command = reader.readLine();
        }

        classMethods.entrySet().stream()
                .sorted((a, b) -> {
                    int result;

                    Integer aSum = 0;
                    Integer bSum = 0;

                    for (HashSet<String> set : a.getValue().values()) {
                        aSum += set.size();
                    }

                    for (HashSet<String> set : b.getValue().values()) {
                        bSum += set.size();
                    }

                    result = bSum.compareTo(aSum);

                    if (result == 0) {
                        Integer aMethods = 0;
                        Integer bMethods = 0;

                        aMethods = a.getValue().size();
                        bMethods = b.getValue().size();

                        result = aMethods.compareTo(bMethods);

                        if (result == 0) {
                            result = a.getKey().compareTo(b.getKey());
                        }
                    }

                    return result;
                })
                .forEach(pair -> {
                    System.out.println(pair.getKey() + ":");

                    pair.getValue().entrySet().stream()
                            .sorted(Comparator.<Map.Entry<String, HashSet<String>>>comparingInt(innerPair -> innerPair.getValue().size())
                                    .reversed()
                                    .thenComparing(innerPair -> innerPair.getKey()))
                            .forEach(innerPair -> {
                                System.out.println("##" + innerPair.getKey());

                                innerPair.getValue().stream()
                                        .sorted(Comparator.<String>comparingInt(a -> a.length())
                                                .thenComparing(a -> a))
                                        .forEach(a -> System.out.println("####" + a));
                            });
                });
    }
}