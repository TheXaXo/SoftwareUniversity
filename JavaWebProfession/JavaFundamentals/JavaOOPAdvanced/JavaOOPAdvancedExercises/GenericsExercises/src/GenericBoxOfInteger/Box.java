package GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Object> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public <T> void add(T item) {
        this.list.add(item);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (Object entry : this.list) {
            out.append(String.format("%s: %s%n", entry.getClass().getName(), entry));
        }

        return out.toString();
    }
}