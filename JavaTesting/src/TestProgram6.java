import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TestProgram6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeMap<String, TreeMap<String, Integer>> userLogins = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = console.nextLine().split("\\s");

            String ipAdress = split[0];
            String userName = split[1];
            int duration = Integer.parseInt(split[2]);

            TreeMap<String, Integer> ipDuration = new TreeMap<>();
            ipDuration.put(ipAdress, duration);

            if (!userLogins.containsKey(userName)) {
                userLogins.put(userName, ipDuration);
            } else {
                if (userLogins.get(userName).containsKey(ipAdress)) {
                    userLogins.get(userName).put(ipAdress, userLogins.get(userName).get(ipAdress) + duration);
                } else {
                    userLogins.get(userName).putAll(ipDuration);
                }
            }
        }

        for (Map.Entry<String, TreeMap<String, Integer>> pair : userLogins.entrySet()) {
            TreeMap<String, Integer> currentIpDuration = pair.getValue();

            int totalDuration = 0;

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> ipDurationPair : currentIpDuration.entrySet()) {
                sb.append(ipDurationPair.getKey() + ", ");
                totalDuration += ipDurationPair.getValue();
            }

            String outputIp = sb.toString().substring(0, sb.length() - 2);

            System.out.printf("%s: %d [%s]%n", pair.getKey(), totalDuration, outputIp);
        }
    }
}