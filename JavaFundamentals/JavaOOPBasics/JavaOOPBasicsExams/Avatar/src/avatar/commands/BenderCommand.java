package avatar.commands;

import avatar.annotations.Inject;
import avatar.models.benders.Bender;
import avatar.models.nations.Nation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BenderCommand extends Command {

    private static final String BENDERS_PACKAGE = "avatar.models.benders.";
    private static final String BENDER_SUFFIX = "Bender";

    @Inject
    private Map<String, Nation> nations;

    public BenderCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = super.getTokens();
        String benderType = tokens[1];

        Class<Bender> benderClass = (Class<Bender>) Class.forName(BENDERS_PACKAGE + benderType + BENDER_SUFFIX);
        Constructor<Bender> constructor = (Constructor<Bender>) benderClass.getDeclaredConstructors()[0];

        Bender bender = constructor.newInstance(
                tokens[2],
                Integer.parseInt(tokens[3]),
                Double.parseDouble(tokens[4])
        );

        Map<String, Nation> nations = this.nations;
        nations.putIfAbsent(benderType, new Nation(benderType));
        nations.get(benderType).addBender(bender);

        return null;
    }
}