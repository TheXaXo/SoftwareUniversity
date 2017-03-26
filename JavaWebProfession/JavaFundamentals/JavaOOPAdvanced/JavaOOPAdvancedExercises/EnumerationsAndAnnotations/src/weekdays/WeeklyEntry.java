package weekdays;

import java.util.Comparator;

public class WeeklyEntry {

    public static final Comparator<WeeklyEntry> BY_DAY_COMPARATOR = createNewComparatorByDay();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.setWeekday(weekday);
        this.setNotes(notes);
    }

    private void setWeekday(String weekday) {
        this.weekday = Weekday.valueOf(weekday.toUpperCase());
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday, this.notes);
    }

    private static Comparator<WeeklyEntry> createNewComparatorByDay() {
        return Comparator.comparingInt(o -> o.weekday.ordinal());
    }
}