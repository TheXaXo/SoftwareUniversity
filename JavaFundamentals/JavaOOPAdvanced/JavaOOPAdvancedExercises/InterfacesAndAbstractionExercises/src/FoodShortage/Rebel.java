package FoodShortage;

public class Rebel extends BaseEntry {

    private String group;

    public Rebel(String name, int age, String group) {
        super(name, age);

        this.setGroup(group);
    }

    public String getGroup() {
        return this.group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void buyFood() {
        this.setFood(this.getFood() + 5);
    }
}