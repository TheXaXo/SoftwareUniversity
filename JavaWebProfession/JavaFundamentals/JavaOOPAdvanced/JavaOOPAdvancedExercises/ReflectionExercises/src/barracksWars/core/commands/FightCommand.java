package barracksWars.core.commands;

import java.lang.reflect.InvocationTargetException;

public class FightCommand extends Command {

    protected FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}