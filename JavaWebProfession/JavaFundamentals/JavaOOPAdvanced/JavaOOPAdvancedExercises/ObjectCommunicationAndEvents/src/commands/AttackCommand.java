package commands;

import models.attackers.Attacker;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}