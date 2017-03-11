package FootballTeamGenerator;

import java.util.HashMap;

public class Team {
    private String name;
    private HashMap<String, Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() < 1) {
            throw new IllegalStateException("A name should not be empty.");
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
    }

    public void removePlayer(String playerName) {
        if (!this.players.containsKey(playerName)) {
            throw new IllegalStateException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }

        this.players.remove(playerName);
    }

    public double getRating() {
        double rating = this.players.values().stream()
                .mapToDouble(player -> player.getAverageSkill())
                .average()
                .orElse(0);

        return rating;
    }
}