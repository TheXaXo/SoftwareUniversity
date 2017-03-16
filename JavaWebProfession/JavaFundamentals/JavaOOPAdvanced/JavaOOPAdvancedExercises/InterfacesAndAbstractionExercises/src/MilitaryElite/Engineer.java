package MilitaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private Set<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    private void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(super.toString());
        out.append("\nRepairs:");

        for (Repair repair : this.getRepairs()) {
            out.append("\n  ").append(repair);
        }

        return out.toString();
    }
}
