package MilitaryElite;

public class Spy extends Soldier implements ISpy {

    private int codeNumber;

    public Spy(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    private void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %d",
                this.getFirstName(), this.getLastName(), this.getId(), this.getCodeNumber());
    }
}