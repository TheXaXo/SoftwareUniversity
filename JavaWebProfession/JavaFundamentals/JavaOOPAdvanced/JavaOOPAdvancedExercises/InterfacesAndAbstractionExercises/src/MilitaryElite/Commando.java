package MilitaryElite;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Commando extends SpecialisedSoldier implements ICommando {

    private Set<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public Set<Mission> getMissions() {
        return Collections.unmodifiableSet(this.missions);
    }

    private void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(super.toString());
        out.append("\nMissions:");

        for (Mission mission : this.getMissions()) {
            out.append("\n  ").append(mission);
        }

        return out.toString();
    }
}