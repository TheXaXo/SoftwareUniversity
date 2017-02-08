import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Integer> nameAge = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split(", ");

            String name = lineArgs[0];
            int age = Integer.parseInt(lineArgs[1]);

            nameAge.put(name, age);
        }

        String condition = reader.readLine();
        int ageCondition = Integer.parseInt(reader.readLine());

        String[] format = reader.readLine().split(" ");

        LinkedHashMap<String, Integer> nameAgeFiltered = filterMap(nameAge, condition, ageCondition);
        printByFormat(nameAgeFiltered, format);
    }

    public static LinkedHashMap<String, Integer> filterMap
            (LinkedHashMap<String, Integer> mapToFilter, String condition, int ageCondition) {

        LinkedHashMap<String, Integer> filteredMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> pair : mapToFilter.entrySet()) {
            int currentAge = pair.getValue();

            if (condition.equals("younger") && currentAge <= ageCondition) {
                filteredMap.put(pair.getKey(), currentAge);
            } else if (condition.equals("older") && currentAge >= ageCondition) {
                filteredMap.put(pair.getKey(), currentAge);
            }
        }

        return filteredMap;
    }

    public static void printByFormat(LinkedHashMap<String, Integer> map, String[] format) {

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (format.length == 1) {
                if (format[0].equals("name")) {
                    System.out.println(pair.getKey());
                } else {
                    System.out.println(pair.getValue());
                }
            } else {
                if (format[0].equals("name")) {
                    System.out.printf("%s - %s%n", pair.getKey(), pair.getValue());
                } else {
                    System.out.printf("%s - %s%n", pair.getValue(), pair.getKey());
                }
            }
        }
    }
}