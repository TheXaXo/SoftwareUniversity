package MilitaryElite;

public class Repair {

    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.setPartName(partName);
        this.setHoursWorked(hoursWorked);
    }

    public String getPartName() {
        return this.partName;
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",
                this.getPartName(), this.getHoursWorked());
    }
}