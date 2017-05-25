package weekdays;

public enum Weekday {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().toLowerCase().substring(1);
    }
}