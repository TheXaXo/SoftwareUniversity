package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Repository;

import java.lang.reflect.InvocationTargetException;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String output = repository.getStatistics();

        return output;
    }
}