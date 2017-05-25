package database;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Database<T> {

    private static final int DEFAULT_ARRAY_LENGTH = 16;

    private T[] items;

    public Database(T... items) {
        this.setItems(items);
    }

    private void setItems(T... items) {
        if (items.length < 1 || items.length > DEFAULT_ARRAY_LENGTH) {
            throw new UnsupportedOperationException("Wrong number of arguments!");
        }

        this.items = (T[]) Array.newInstance(items[0].getClass(), DEFAULT_ARRAY_LENGTH);

        int index = 0;

        for (T item : items) {
            this.items[index++] = item;
        }
    }

    public void addItem(T item) {
        if (item == null) {
            throw new UnsupportedOperationException("Item should not be null!");
        }

        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                return;
            }
        }
    }

    public void remove() {
        for (int i = this.items.length - 1; i >= 0; i--) {
            if (this.items[i] != null) {
                this.items[i] = null;
                return;
            }
        }

        throw new UnsupportedOperationException("Can't remove item from empty array!");
    }

    public T[] fetch() {
        long countOfNotNull = Arrays.stream(this.items).filter(Objects::nonNull).count();

        T[] arrayToReturn = (T[]) Array.newInstance(this.items[0].getClass(), (int) countOfNotNull);

        for (int i = 0; i < arrayToReturn.length; i++) {
            arrayToReturn[i] = this.items[i];
        }

        return arrayToReturn;
    }
}