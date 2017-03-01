package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        String deletedItem = this.data.remove(0);

        return deletedItem;
    }

    public String peek() {
        return this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}