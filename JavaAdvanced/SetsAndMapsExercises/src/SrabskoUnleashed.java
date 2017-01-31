import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Pattern p = Pattern.compile("((?:[A-Za-z]+ ){1,3})@((?:[A-Za-z]+ ){1,3})([0-9]+) ([0-9]+)");

        String command = console.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venueSingers = new LinkedHashMap<>();

        while (!command.equals("End")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = console.nextLine();

                continue;
            }

            String singer = m.group(1).trim();
            String venue = m.group(2).trim();

            int ticketPrice = Integer.parseInt(m.group(3));
            int ticketCount = Integer.parseInt(m.group(4));

            int moneyMade = ticketCount * ticketPrice;

            if (!venueSingers.containsKey(venue)) {
                venueSingers.put(venue, new LinkedHashMap<>());

                venueSingers.get(venue).put(singer, moneyMade);
            } else {
                if (!venueSingers.get(venue).containsKey(singer)) {
                    venueSingers.get(venue).put(singer, moneyMade);
                } else {
                    venueSingers.get(venue).put(singer, venueSingers.get(venue).get(singer) + moneyMade);
                }
            }

            command = console.nextLine();
        }

        for (String venue : venueSingers.keySet()) {
            System.out.println(venue);

            venueSingers.get(venue).entrySet().stream()
                    .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(a -> a.getValue())
                            .reversed())
                    .forEach(a -> System.out.printf("#  %s -> %d%n", a.getKey(), a.getValue()));
        }
    }
}