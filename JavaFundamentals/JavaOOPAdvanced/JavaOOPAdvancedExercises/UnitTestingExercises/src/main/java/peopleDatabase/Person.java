package peopleDatabase;

public class Person {

    private String userName;
    private int id;

    public Person(String userName, int id) {
        this.setUserName(userName);
        this.setId(id);
    }

    public String getUserName() {
        return this.userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }
}
