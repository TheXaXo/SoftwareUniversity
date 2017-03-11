package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        HashMap<String, Team> teams = new HashMap<>();

        while (!command.equals("END")) {
            String[] tokens = command.split(";");

            switch (tokens[0]) {
                case "Team":
                    String name = tokens[1];

                    Team team;

                    try {
                        team = new Team(name);
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }

                    teams.put(team.getName(), team);
                    break;

                case "Add":
                    String teamToAddTo = tokens[1];
                    String playerName = tokens[2];

                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);

                    if (!teams.containsKey(teamToAddTo)) {
                        System.out.printf("Team %s does not exist.%n", teamToAddTo);
                        break;
                    }

                    Player player;

                    try {
                        player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }

                    teams.get(teamToAddTo).addPlayer(player);
                    break;

                case "Remove":
                    String teamName = tokens[1];
                    String playerToBeRemoved = tokens[2];

                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }

                    try {
                        teams.get(teamName).removePlayer(playerToBeRemoved);
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Rating":
                    String teamToShowStatsFor = tokens[1];

                    if (!teams.containsKey(teamToShowStatsFor)) {
                        System.out.printf("Team %s does not exist.%n", teamToShowStatsFor);
                        break;
                    }

                    System.out.println(teamToShowStatsFor + " - " + Math.round(teams.get(teamToShowStatsFor).getRating()));
                    break;
            }

            command = reader.readLine();
        }
    }
}