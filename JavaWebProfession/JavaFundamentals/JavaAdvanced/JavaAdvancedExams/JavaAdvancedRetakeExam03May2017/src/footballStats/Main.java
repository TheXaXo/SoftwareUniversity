package footballStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        Map<String, List<Match>> teamMatches = new HashMap<>();

        while (!command.equals("Season End")) {
            String[] tokens = command.split(" result ");
            String[] teamTokens = tokens[0].split(" - ");
            String[] resultTokens = tokens[1].split(":");

            String teamOne = teamTokens[0];
            String teamTwo = teamTokens[1];
            int teamOneScore = Integer.parseInt(resultTokens[0]);
            int teamTwoScore = Integer.parseInt(resultTokens[1]);

            teamMatches.putIfAbsent(teamOne, new ArrayList<>());
            teamMatches.putIfAbsent(teamTwo, new ArrayList<>());

            teamMatches.get(teamOne).add(new Match(teamOne, teamTwo, teamOneScore, teamTwoScore));
            teamMatches.get(teamTwo).add(new Match(teamTwo, teamOne, teamTwoScore, teamOneScore));

            command = reader.readLine();
        }

        String[] teamsToPrint = reader.readLine().split(", ");

        for (String teamToPrint : teamsToPrint) {
            teamMatches.get(teamToPrint).stream()
                    .sorted(Comparator.comparing(Match::getTeamTwo))
                    .forEach(System.out::println);
        }
    }
}

class Match {

    private String teamOne;
    private String teamTwo;
    private int teamOneScore;
    private int teamTwoScore;

    public Match(String teamOne, String teamTwo, int teamOneScore, int teamTwoScore) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
    }

    public String getTeamTwo() {
        return this.teamTwo;
    }

    @Override
    public String toString() {
        return String.format("%s - %s -> %d:%d",
                this.teamOne, this.teamTwo, this.teamOneScore, this.teamTwoScore);
    }
}