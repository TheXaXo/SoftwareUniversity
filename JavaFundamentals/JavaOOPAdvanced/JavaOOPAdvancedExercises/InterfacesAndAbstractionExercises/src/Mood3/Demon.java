package Mood3;

public class Demon extends GameObject {

    public Demon(String userName, int level, double specialPoints) {
        super(userName, level, specialPoints);
        super.setHashedPassword(Integer.toString(super.getUserName().length() * 217));
    }
}