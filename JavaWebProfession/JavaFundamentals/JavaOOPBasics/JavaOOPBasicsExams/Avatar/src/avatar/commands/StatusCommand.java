package avatar.commands;

import avatar.annotations.Inject;
import avatar.models.nations.Nation;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class StatusCommand extends Command {

    @Inject
    private Map<String, Nation> nations;

    public StatusCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return this.nations.get(super.getTokens()[1]).toString();
    }
}