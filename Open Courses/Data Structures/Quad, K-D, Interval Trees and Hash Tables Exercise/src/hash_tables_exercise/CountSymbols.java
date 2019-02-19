package hash_tables_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomHashDictionary<Character, Integer> symbolsCount = new CustomHashDictionary<>();
        String line = reader.readLine();

        for (char c : line.toCharArray()) {
            if (!symbolsCount.containsKey(c)) {
                symbolsCount.put(c, 1);

                continue;
            }

            symbolsCount.put(c, symbolsCount.get(c) + 1);
        }

        List<KeyValue<Character, Integer>> entries = new ArrayList<>();

        for (KeyValue<Character, Integer> pair : symbolsCount) {
            entries.add(pair);
        }

        entries.sort(Comparator.comparing(KeyValue::getKey));

        for (KeyValue<Character, Integer> pair : entries) {
            System.out.printf("%s: %d time/s\n", pair.getKey(), pair.getValue());
        }
    }
}