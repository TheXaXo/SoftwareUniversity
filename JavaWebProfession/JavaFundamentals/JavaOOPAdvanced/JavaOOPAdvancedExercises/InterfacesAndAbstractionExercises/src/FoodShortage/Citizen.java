package FoodShortage;

public class Citizen extends BaseEntry implements Identifiable, Birthable {

    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        super(name, age);

        this.setId(id);
        this.setBirthdate(birthdate);
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void buyFood() {
        this.setFood(this.getFood() + 10);
    }
}
