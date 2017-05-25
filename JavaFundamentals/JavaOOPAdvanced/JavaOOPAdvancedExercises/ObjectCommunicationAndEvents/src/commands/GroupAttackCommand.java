package commands;

import models.groups.AttackGroup;

public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}