import java.util.*;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> userIp = new TreeMap<>();

        while (!command.equals("end")) {
            String[] inputArgs = command.split(" ");

            String ipAddress = inputArgs[0].split("=")[1];
            String userName = inputArgs[2].split("=")[1];

            if (!userIp.containsKey(userName)) {
                userIp.put(userName, new LinkedHashMap<>());

                userIp.get(userName).put(ipAddress, 1);
            } else {
                if (userIp.get(userName).containsKey(ipAddress)) {
                    userIp.get(userName).put(ipAddress, userIp.get(userName).get(ipAddress) + 1);
                } else {
                    userIp.get(userName).put(ipAddress, 1);
                }
            }

            command = console.nextLine();
        }

        for (String userName : userIp.keySet()) {
            System.out.println(userName + ":");

            ArrayList<Map.Entry<String, Integer>> userIpAsList = userIp.get(userName).entrySet().stream()
                    .collect(Collectors.toCollection(ArrayList::new));

            for (Map.Entry<String, Integer> pair : userIpAsList) {
                if (pair.equals(userIpAsList.get(userIpAsList.size() - 1))) {
                    System.out.printf("%s => %d.%n", pair.getKey(), pair.getValue());
                } else {
                    System.out.printf("%s => %d, ", pair.getKey(), pair.getValue());
                }
            }
        }
    }
}