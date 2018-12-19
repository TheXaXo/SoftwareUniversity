import java.util.Arrays;
import java.util.Iterator;

public class ReversedList<T> implements Iterable<T> {
    private T[] items;
    private int elementsCount;

    @SuppressWarnings("unchecked")
    public ReversedList() {
        items = (T[]) new Object[2];
        elementsCount = 0;
    }

    public void add(T item) {
        if (elementsCount >= items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }

        elementsCount++;
        items[elementsCount - 1] = item;
    }

    public int count() {
        return elementsCount;
    }

    public int capacity() {
        return items.length;
    }

    public T get(int index) {
        if (index < 0 || index >= elementsCount) {
            return null;
        }

        return items[elementsCount - 1 - index];
    }

    public boolean set(int index, T element) {
        if (index < 0 || index >= elementsCount) {
            return false;
        }

        items[index] = element;
        return true;
    }

    public boolean removeAt(int index) {
        if (index < 0 || index >= elementsCount) {
            return false;
        }

        for (int i = index; i < elementsCount; i++) {
            if (i == elementsCount - 1) {
                items[i] = null;
                break;
            }

            items[i] = items[i + 1];
        }

        elementsCount--;
        return true;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = elementsCount - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                return items[currentIndex--];
            }
        };
    }
}