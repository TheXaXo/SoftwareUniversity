import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] participants = Arrays.stream(console.nextLine().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        String[] songs = Arrays.stream(console.nextLine().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        String command = console.nextLine();

        LinkedHashMap<String, ArrayList<String>> singerAwards = new LinkedHashMap<>();

        while (!command.equals("dawn")) {
            String[] split = Arrays.stream(command.split(","))
                    .map(String::trim)
                    .toArray(String[]::new);

            String participant = split[0];
            String song = split[1];
            String award = split[2];

            if (!Arrays.stream(participants).anyMatch(a -> a.equals(participant))
                    || !Arrays.stream(songs).anyMatch(a -> a.equals(song))) {
                command = console.nextLine();
                continue;
            }

            if (singerAwards.entrySet().stream().anyMatch(a -> a.getValue().contains(award))) {
                command = console.nextLine();
                continue;
            }

            if (!singerAwards.containsKey(participant)) {
                singerAwards.put(participant, new ArrayList<>(Arrays.asList(award)));
            } else {
                ArrayList<String> currentAwards = singerAwards.get(participant);
                currentAwards.add(award);

                currentAwards = currentAwards.stream()
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

                singerAwards.put(participant, currentAwards);
            }

            command = console.nextLine();
        }

        ArrayList<Map.Entry<String, ArrayList<String>>> singerAwardsSorted =
                singerAwards.entrySet()
                        .stream()
                        .sorted(Comparator.<Map.Entry<String, ArrayList<String>>>comparingInt(a -> a.getValue().size())
                                .reversed()
                                .thenComparing(a -> a.getKey()))
                        .collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<String, ArrayList<String>> pair : singerAwardsSorted) {
            System.out.printf("%s: %d awards%n", pair.getKey(), pair.getValue().size());

            ArrayList<String> currentSingerAwards = pair.getValue().stream()
                    .sorted(Comparator.comparing(a -> a))
                    .collect(Collectors.toCollection(ArrayList::new));

            for (String award : currentSingerAwards) {
                System.out.printf("--%s%n", award);
            }

            if (currentSingerAwards.size() == 0) {
                System.out.println("No awards");
            }
        }

        if (singerAwardsSorted.size() == 0) {
            System.out.println("No awards");
        }
    }
}