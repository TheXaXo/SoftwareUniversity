import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        LinkedHashMap<String, Integer> resourceQuantity = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(console.nextLine());

            if (!resourceQuantity.containsKey(resource)) {
                resourceQuantity.put(resource, quantity);
            } else {
                resourceQuantity.put(resource, resourceQuantity.get(resource) + quantity);
            }

            command = console.nextLine();
        }

        for (String resource : resourceQuantity.keySet()) {
            System.out.printf("%s -> %d%n", resource, resourceQuantity.get(resource));
        }
    }
}