package models.groups;

import models.attackers.Attacker;
import models.targets.ObservableTarget;
import models.targets.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> members;

    public Group() {
        this.members = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.members.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker member : this.members) {
            member.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker member : this.members) {
            member.attack();
        }
    }
}