package eventImplementation;

public class NameChange implements EventObject {

    private String changedName;

    public NameChange(String changedName) {
        this.changedName = changedName;
    }

    @Override
    public String getChangedName() {
        return this.changedName;
    }
}
