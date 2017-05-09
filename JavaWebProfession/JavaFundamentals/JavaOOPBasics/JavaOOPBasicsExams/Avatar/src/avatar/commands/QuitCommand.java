package avatar.commands;

import avatar.annotations.Inject;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class QuitCommand extends Command {

    @Inject
    private List<String> issuedWarsByNations;

    public QuitCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < this.issuedWarsByNations.size(); i++) {
            out.append(String.format("War %d issued by %s\n", i + 1, this.issuedWarsByNations.get(i)));
        }

        out.setLength(out.length() - 1);
        return out.toString();
    }
}