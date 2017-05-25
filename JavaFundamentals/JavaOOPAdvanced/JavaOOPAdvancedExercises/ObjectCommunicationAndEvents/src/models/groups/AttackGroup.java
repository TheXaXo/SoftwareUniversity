package models.groups;

import models.attackers.Attacker;
import models.targets.ObservableTarget;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();
}
