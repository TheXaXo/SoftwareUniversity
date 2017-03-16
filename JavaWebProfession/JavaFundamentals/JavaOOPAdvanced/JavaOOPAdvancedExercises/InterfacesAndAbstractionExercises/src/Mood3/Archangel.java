package Mood3;

public class Archangel extends GameObject {

    public Archangel(String userName, int level, double specialPoints) {
        super(userName, level, specialPoints);
        super.setHashedPassword(new StringBuilder(super.getUserName()).reverse().toString() +
                Integer.toString(super.getUserName().length() * 21));
    }
}