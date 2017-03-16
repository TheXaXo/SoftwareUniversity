package MilitaryElite;

public class Mission {

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    public String getCodeName() {
        return this.codeName;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getState() {
        return this.state;
    }

    private void setState(String state) {
        if (!state.equals("inProgress") && !state.equals("Finished")) {
            throw new IllegalArgumentException("Invalid mission state!");
        }

        this.state = state;
    }

    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(), this.getState());
    }
}