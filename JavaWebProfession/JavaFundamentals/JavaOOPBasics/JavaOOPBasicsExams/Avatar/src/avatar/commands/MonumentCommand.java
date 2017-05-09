package avatar.commands;

import avatar.annotations.Inject;
import avatar.models.monuments.Monument;
import avatar.models.nations.Nation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MonumentCommand extends Command {

    private static final String MONUMENTS_PACKAGE = "avatar.models.monuments.";
    private static final String MONUMENT_SUFFIX = "Monument";

    @Inject
    private Map<String, Nation> nations;

    public MonumentCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();
        String monumentType = tokens[1];

        Class<Monument> monumentClass = (Class<Monument>) Class.forName(MONUMENTS_PACKAGE + monumentType + MONUMENT_SUFFIX);
        Constructor<Monument> constructor = (Constructor<Monument>) monumentClass.getDeclaredConstructors()[0];

        Monument monument = constructor.newInstance(tokens[2], Integer.parseInt(tokens[3]));

        Map<String, Nation> nations = this.nations;
        nations.putIfAbsent(monumentType, new Nation(monumentType));
        nations.get(monumentType).addMonument(monument);

        return null;
    }
}