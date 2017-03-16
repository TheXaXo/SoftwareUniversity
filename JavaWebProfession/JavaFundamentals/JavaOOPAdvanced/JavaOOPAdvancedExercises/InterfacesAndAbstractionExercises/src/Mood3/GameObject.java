package Mood3;

public abstract class GameObject implements IGameObject {

    private String userName;
    private String hashedPassword;
    private int level;
    private double specialPoints;

    protected GameObject(String userName, int level, double specialPoints) {
        this.setUserName(userName);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    public String getUserName() {
        return this.userName;
    }

    private void setUserName(String getUserName) {
        this.userName = getUserName;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public double getSpecialPoints() {
        return this.specialPoints;
    }

    private void setSpecialPoints(double specialPoints) {
        this.specialPoints = specialPoints;
    }
}