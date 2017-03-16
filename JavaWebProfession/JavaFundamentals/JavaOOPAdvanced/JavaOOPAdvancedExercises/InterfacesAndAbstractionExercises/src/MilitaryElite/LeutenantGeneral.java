package MilitaryElite;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private Set<Soldier> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.setPrivates(new LinkedHashSet<>());
    }

    public void addPrivate(Soldier _private) {
        this.privates.add(_private);
    }

    @Override
    public Set<Soldier> getPrivates() {
        return Collections.unmodifiableSet(this.privates);
    }

    private void setPrivates(Set<Soldier> privates) {
        this.privates = privates;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(super.toString());
        out.append("\nPrivates:");

        for (Soldier soldier : this.getPrivates()) {
            out.append("\n  ").append(soldier);
        }

        return out.toString();
    }
}