import java.util.*;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> userIpAddresses = new TreeMap<>();

        while (!command.equals("end")) {
            String[] split = command.split("\\s");

            String ip = split[0].split("=")[1];
            String username = split[2].split("=")[1];

            if (!userIpAddresses.containsKey(username)) {
                LinkedHashMap<String, Integer> ipCount = new LinkedHashMap<>();
                ipCount.put(ip, 1);

                userIpAddresses.put(username, ipCount);
            } else {
                LinkedHashMap<String, Integer> currentIpCount = userIpAddresses.get(username);

                if (!currentIpCount.containsKey(ip)) {
                    currentIpCount.put(ip, 1);
                } else {
                    currentIpCount.put(ip, currentIpCount.get(ip) + 1);
                }
            }

            command = console.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> pair : userIpAddresses.entrySet()) {
            System.out.printf("%s:%n", pair.getKey());

            ArrayList<Map.Entry<String, Integer>> ipCount = pair.getValue().entrySet()
                    .stream()
                    .collect(Collectors.toCollection(ArrayList::new));

            for (int i = 0; i < ipCount.size(); i++) {
                Map.Entry<String, Integer> currentIpCount = ipCount.get(i);

                if (i == ipCount.size() - 1) {
                    System.out.printf("%s => %d.%n", currentIpCount.getKey(), currentIpCount.getValue());
                } else {
                    System.out.printf("%s => %d, ", currentIpCount.getKey(), currentIpCount.getValue());
                }
            }
        }
    }
}