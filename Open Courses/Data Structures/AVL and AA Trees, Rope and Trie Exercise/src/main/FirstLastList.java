package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FirstLastList<T extends Comparable<T>> implements IFirstLastList<T> {
    private LinkedList<T> byOrderOfAdding;
    private SortedMultiSet<T> byAscending;
    private SortedMultiSet<T> byDescending;

    public FirstLastList() {
        this.byOrderOfAdding = new LinkedList<>();
        this.byAscending = new SortedMultiSet<>((o1, o2) -> o2.compareTo(o1));
        this.byDescending = new SortedMultiSet<>((o1, o2) -> o1.compareTo(o2));
    }

    @Override
    public void add(T element) {
        this.byOrderOfAdding.addLast(element);
        this.byAscending.add(element);
        this.byDescending.add(element);
    }

    @Override
    public int getCount() {
        return this.byOrderOfAdding.size();
    }

    @Override
    public Iterable<T> first(int count) {
        this.checkCount(count);

        return this.returnCount(count, this.byOrderOfAdding.iterator());
    }

    @Override
    public Iterable<T> last(int count) {
        this.checkCount(count);

        return this.returnCount(count, this.byOrderOfAdding.descendingIterator());
    }

    @Override
    public Iterable<T> min(int count) {
        this.checkCount(count);

        return this.returnCount(count, this.byAscending.iterator());
    }

    @Override
    public Iterable<T> max(int count) {
        this.checkCount(count);

        return this.returnCount(count, this.byDescending.iterator());
    }

    @Override
    public void clear() {
        this.byOrderOfAdding.clear();
        this.byAscending.clear();
        this.byDescending.clear();
    }

    @Override
    public int removeAll(T element) {
        int count = this.byAscending.removeAllCopies(element);
        this.byDescending.removeAllCopies(element);

        Iterator<T> iterator = this.byOrderOfAdding.iterator();

        while (iterator.hasNext()) {
            T current = iterator.next();

            if (current.compareTo(element) == 0) {
                this.byOrderOfAdding.remove(current);
                iterator = this.byOrderOfAdding.iterator();
            }
        }

        return count;
    }

    private void checkCount(int count) {
        if (count > this.byOrderOfAdding.size()) {
            throw new IllegalArgumentException();
        }
    }

    private Iterable<T> returnCount(int count, Iterator<T> iterator) {
        List<T> listToReturn = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            listToReturn.add(iterator.next());
        }

        return listToReturn;
    }
}