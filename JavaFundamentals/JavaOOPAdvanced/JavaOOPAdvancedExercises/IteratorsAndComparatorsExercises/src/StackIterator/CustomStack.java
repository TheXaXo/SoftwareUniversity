package StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer> {

    private List<Integer> items;

    public CustomStack() {
        this.items = new ArrayList();
    }


    public void push(int item) {
        this.items.add(item);
    }

    public void pop() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("No elements");
        }

        this.items.remove(this.items.size() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomStackIterator();
    }

    private final class CustomStackIterator implements Iterator<Integer> {

        private int index;

        public CustomStackIterator() {
            this.index = items.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public Integer next() {
            return items.get(index--);
        }
    }
}