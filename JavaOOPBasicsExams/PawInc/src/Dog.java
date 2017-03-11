public class Dog extends Animal {

    private int amountOfCommand;

    public Dog(String name, int age, int amountOfCommand) {
        super(name, age);
        this.setAmountOfCommand(amountOfCommand);
    }

    public int getAmountOfCommand() {
        return this.amountOfCommand;
    }

    private void setAmountOfCommand(int amountOfCommand) {
        this.amountOfCommand = amountOfCommand;
    }
}