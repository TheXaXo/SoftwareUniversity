import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        HashMap<String, LinkedHashMap<String, Integer>> companyProducts = new HashMap<>();

        Pattern p = Pattern.compile("\\|([^\\s]+)\\s-\\s([0-9]+)\\s-\\s([^\\|]+)\\|");

        for (int i = 0; i < n; i++) {
            Matcher m = p.matcher(reader.readLine());

            if (!m.find()) {
                continue;
            }

            String company = m.group(1);
            int quantity = Integer.parseInt(m.group(2));
            String product = m.group(3);

            if (!companyProducts.containsKey(company)) {
                companyProducts.put(company, new LinkedHashMap<>());

                companyProducts.get(company).put(product, quantity);
            } else {
                if (!companyProducts.get(company).containsKey(product)) {
                    companyProducts.get(company).put(product, quantity);
                } else {
                    companyProducts.get(company).put(product, companyProducts.get(company).get(product) + quantity);
                }
            }
        }

        companyProducts.entrySet().stream()
                .sorted(Comparator.comparing(a -> a.getKey()))
                .forEach(pair -> {
                    System.out.printf("%s: ", pair.getKey());

                    StringBuilder output = new StringBuilder();
                    for (Map.Entry<String, Integer> productPair : pair.getValue().entrySet()) {
                        output.append(productPair.getKey()).append("-").append(productPair.getValue()).append(", ");
                    }

                    String toPrint = output.substring(0, output.length() - 2);

                    System.out.println(toPrint);
                });
    }
}