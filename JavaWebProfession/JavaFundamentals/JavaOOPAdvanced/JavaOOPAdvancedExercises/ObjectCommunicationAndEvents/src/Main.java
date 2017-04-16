import commands.CommandExecutor;
import commands.Executor;
import commands.GroupAttackCommand;
import commands.GroupTargetCommand;
import logger.CombatLogger;
import logger.EventLogger;
import logger.Handler;
import models.attackers.Attacker;
import models.attackers.Warrior;
import models.groups.AttackGroup;
import models.groups.Group;
import models.targets.Dragon;
import models.targets.ObservableTarget;

public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);

        Attacker warrior = new Warrior("Gosho", 69, combatLogger);
        Attacker warriorTwo = new Warrior("Pesho", 420, combatLogger);
        ObservableTarget dragon = new Dragon("Kotka", 450, 10, combatLogger);

        Executor commandExecutor = new CommandExecutor();

        AttackGroup group = new Group();
        group.addMember(warrior);
        group.addMember(warriorTwo);

        commandExecutor.executeCommand(new GroupTargetCommand(group, dragon));
        commandExecutor.executeCommand(new GroupAttackCommand(group));
    }
}