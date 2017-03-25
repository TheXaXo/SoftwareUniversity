package Collection;

import java.util.Iterator;

public class ListyIterator<T extends String> implements Iterable<String> {

    private T[] items;
    private int currentIndex;

    public ListyIterator(T... items) {
        this.setItems(items);
        this.currentIndex = 0;
    }

    private void setItems(T... items) {
        this.items = items;
    }

    public boolean hasNext() {
        return this.items.length - 1 != this.currentIndex;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.items.length == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.items[this.currentIndex]);
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIter();
    }

    private final class ListyIter implements Iterator<String> {

        private int index;

        public ListyIter() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public String next() {
            return items[index++];
        }
    }
}