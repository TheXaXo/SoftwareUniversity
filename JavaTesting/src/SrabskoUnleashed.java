import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        Pattern p = Pattern.compile("((?:[A-Za-z]+\\s){1,3})@((?:[A-Za-z]+\\s){1,3})([0-9]+)\\s([0-9]+)");

        LinkedHashMap<String, LinkedHashMap<String, Long>> venueSingers = new LinkedHashMap<>();

        while (!command.equals("End")) {
            Matcher m = p.matcher(command);

            if (!m.matches()) {
                command = console.nextLine();
                continue;
            }

            String singer = m.group(1).trim();
            String venue = m.group(2).trim();
            int price = Integer.parseInt(m.group(3));
            int count = Integer.parseInt(m.group(4));

            long moneyMade = (long) price * count;

            if (!venueSingers.containsKey(venue)) {
                LinkedHashMap<String, Long> singerMoney = new LinkedHashMap<>();
                singerMoney.put(singer, moneyMade);

                venueSingers.put(venue, singerMoney);
            } else {
                LinkedHashMap<String, Long> currentVenueSingerMoney = venueSingers.get(venue);

                if (!currentVenueSingerMoney.containsKey(singer)) {
                    currentVenueSingerMoney.put(singer, moneyMade);
                } else {
                    currentVenueSingerMoney.put(singer, currentVenueSingerMoney.get(singer) + moneyMade);
                }
            }

            command = console.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> pair : venueSingers.entrySet()) {
            ArrayList<Map.Entry<String, Long>> currentVenueSingerMoney = pair.getValue().entrySet()
                    .stream()
                    .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(a -> a.getValue()).reversed())
                    .collect(Collectors.toCollection(ArrayList::new));

            System.out.println(pair.getKey());

            for (Map.Entry<String, Long> currentVenueSingerMoneyPair : currentVenueSingerMoney) {
                System.out.printf("#  %s -> %d%n", currentVenueSingerMoneyPair.getKey()
                        , currentVenueSingerMoneyPair.getValue());
            }
        }
    }
}