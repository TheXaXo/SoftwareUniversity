package FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private ArrayList<Person> firstTeam;
    private ArrayList<Person> reserveTeam;

    public Team(String name) {
        this.setName(name);
        this.setFirstTeam(new ArrayList<>());
        this.setReserveTeam(new ArrayList<>());
    }

    private void setName(String name) {
        this.name = name;
    }

    private ArrayList<Person> getFirst() {
        return this.firstTeam;
    }

    private void setFirstTeam(ArrayList<Person> firstTeam) {
        this.firstTeam = firstTeam;
    }

    private ArrayList<Person> getReserve() {
        return this.reserveTeam;
    }

    private void setReserveTeam(ArrayList<Person> reserveTeam) {
        this.reserveTeam = reserveTeam;
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.getFirst().add(player);
        } else {
            this.getReserve().add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.getFirst());
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.getReserve());
    }
}