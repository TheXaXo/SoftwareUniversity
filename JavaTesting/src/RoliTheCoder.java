import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoliTheCoder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = String.join(" ", console.nextLine().split("\\s"));

        Pattern p = Pattern.compile("(\\d+)\\s+#([^\\s]+)((?:\\s+@[^\\s]+)+)*");

        TreeMap<String, String> idEvent = new TreeMap<>();
        TreeMap<String, ArrayList<String>> eventParticipants = new TreeMap<>();

        while (!command.equals("Time for Code")) {
            Matcher m = p.matcher(command);

            if (!m.find()) {
                command = console.nextLine();
                continue;
            }

            String id = m.group(1);
            String eventName = m.group(2);
            String participantsString = m.group(3);

            if (participantsString == null) {
                participantsString = "";
            }

            ArrayList participants = Arrays.stream(participantsString
                    .split("\\s"))
                    .filter(a -> a.length() > 0)
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));


            if (idEvent.containsKey(id) && idEvent.get(id).equals(eventName)) {
                ArrayList<String> allParticipants = eventParticipants.get(eventName);
                allParticipants.addAll(participants);

                allParticipants = allParticipants.stream()
                        .filter(a -> a.length() > 0)
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

                eventParticipants.put(eventName, allParticipants);
            } else if (!idEvent.containsKey(id) && !eventParticipants.containsKey(eventName)) {
                idEvent.put(id, eventName);

                eventParticipants.put(eventName, participants);
            }

            command = console.nextLine();
        }

        ArrayList<Map.Entry<String, ArrayList<String>>> eventParticipantsSorted =
                eventParticipants.entrySet()
                        .stream()
                        .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                        .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<String, ArrayList<String>> pair : eventParticipantsSorted) {
            ArrayList<String> participants = pair.getValue()
                    .stream()
                    .sorted(String::compareToIgnoreCase)
                    .collect(Collectors.toCollection(ArrayList::new));

            System.out.printf("%s - %d%n", pair.getKey(), participants.size());

            for (String participant : participants) {
                System.out.println(participant);
            }
        }
    }
}