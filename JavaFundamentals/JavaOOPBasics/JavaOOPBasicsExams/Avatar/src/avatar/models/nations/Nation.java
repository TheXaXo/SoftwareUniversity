package avatar.models.nations;

import avatar.models.benders.Bender;
import avatar.models.monuments.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {

    private String type;
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(String type) {
        this.type = type;
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    public double getTotalPower() {
        double bendersPower = this.benders.stream().
                mapToDouble(Bender::getTotalPower).
                sum();
        long monumentsAffinity = this.monuments.stream()
                .mapToLong(Monument::getAffinity)
                .sum();

        return bendersPower + ((bendersPower / 100) * monumentsAffinity);
    }

    public void deleteBenders() {
        this.benders.clear();
    }

    public void deleteMonuments() {
        this.monuments.clear();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s Nation%n", this.type));

        if (this.benders.isEmpty()) {
            out.append("Benders: None\n");
        } else {
            out.append("Benders:\n");

            for (Bender bender : this.benders) {
                out.append(String.format("###%s%n", bender));
            }
        }

        if (this.monuments.isEmpty()) {
            out.append("Monuments: None\n");
        } else {
            out.append("Monuments:\n");

            for (Monument monument : this.monuments) {
                out.append(String.format("###%s\n", monument));
            }
        }

        out.setLength(out.length() - 1);
        return out.toString();
    }
}