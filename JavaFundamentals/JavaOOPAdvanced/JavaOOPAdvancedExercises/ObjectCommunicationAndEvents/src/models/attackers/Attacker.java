package models.attackers;

import models.targets.ObservableTarget;

public interface Attacker {

    void attack();
    void setTarget(ObservableTarget target);
}