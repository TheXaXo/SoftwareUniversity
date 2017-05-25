package linkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomLinkedList<T> implements Iterable<T> {

    private List<T> items;

    public CustomLinkedList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public void remove(T item) {
        if (this.items.contains(item)) {
            this.items.remove(this.items.indexOf(item));
        }
    }

    public int getSize() {
        return this.items.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private final class CustomIterator implements Iterator<T> {

        private int index;

        public CustomIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < items.size();
        }

        @Override
        public T next() {
            return items.get(this.index++);
        }
    }
}