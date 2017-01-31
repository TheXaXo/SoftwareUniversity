import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeMap<String, TreeMap<String, Integer>> userIp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = console.nextLine().split(" ");

            String ip = split[0];
            String userName = split[1];
            int duration = Integer.parseInt(split[2]);

            if (!userIp.containsKey(userName)) {
                userIp.put(userName, new TreeMap<>());

                userIp.get(userName).put(ip, duration);
            } else {
                if (!userIp.get(userName).containsKey(ip)) {
                    userIp.get(userName).put(ip, duration);
                } else {
                    userIp.get(userName).put(ip, userIp.get(userName).get(ip) + duration);
                }
            }
        }

        for (String userName : userIp.keySet()) {
            int totalDuration = userIp.get(userName).values().stream().mapToInt(a -> a).sum();

            System.out.printf("%s: %d ", userName, totalDuration);

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            ArrayList<String> ip = userIp.get(userName).keySet().stream()
                    .collect(Collectors.toCollection(ArrayList::new));

            for (int i = 0; i < ip.size(); i++) {
                if (i != ip.size() - 1) {
                    sb.append(ip.get(i));
                    sb.append(", ");
                } else {
                    sb.append(ip.get(i));
                }
            }

            System.out.println(sb.toString() + "]");
        }
    }
}