package avatar.commands;

import avatar.annotations.Inject;
import avatar.models.nations.Nation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class WarCommand extends Command {

    @Inject
    private Map<String, Nation> nations;

    @Inject
    private List<String> issuedWarsByNation;

    public WarCommand(String[] tokens) {
        super(tokens);
    }

    @Override
    public String execute() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.issuedWarsByNation.add(super.getTokens()[1]);

        double highestPower = this.nations.values().stream()
                .sorted((a, b) -> Double.compare(b.getTotalPower(), a.getTotalPower()))
                .mapToDouble(Nation::getTotalPower)
                .findFirst()
                .orElse(0);

        for (Nation nation : this.nations.values()) {
            if (nation.getTotalPower() != highestPower) {
                nation.deleteBenders();
                nation.deleteMonuments();
            }
        }

        return null;
    }
}