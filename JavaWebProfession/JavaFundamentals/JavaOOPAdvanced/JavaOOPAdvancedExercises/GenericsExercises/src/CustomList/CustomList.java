package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> items;

    public CustomList() {
        this.items = new ArrayList<T>();
    }

    public void add(T element) {
        this.items.add(element);
    }

    public T remove(int index) {
        T item = this.items.get(index);
        this.items.remove(index);

        return item;
    }

    public boolean contains(T element) {
        return this.items.contains(element);
    }

    public void swap(int i1, int i2) {
        T elementOld = this.items.get(i1);

        this.items.set(i1, this.items.get(i2));
        this.items.set(i2, elementOld);
    }

    public int countGreaterThan(T element) {
        int count = 0;

        for (T currentElement : this.items) {
            if (element.compareTo(currentElement) < 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("List should not be empty!");
        }

        T maxElement = this.items.get(0);

        for (int i = 1; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(maxElement) > 0) {
                maxElement = this.items.get(i);
            }
        }

        return maxElement;
    }

    public T getMin() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("List should not be empty!");
        }

        T minElement = this.items.get(0);

        for (int i = 1; i < this.items.size(); i++) {
            if (this.items.get(i).compareTo(minElement) < 0) {
                minElement = this.items.get(i);
            }
        }

        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (T element : this.items) {
            out.append(element).append("\n");
        }

        return out.toString();
    }
}