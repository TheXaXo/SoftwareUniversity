package iteratorTests;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class ListIterator<T> {

    private List<T> items;
    private int internalIndex;

    public ListIterator(T... items) throws OperationNotSupportedException {
        this.setItems(items);
    }

    private void setItems(T... items) throws OperationNotSupportedException {
        this.items = new ArrayList<>();

        for (T item : items) {
            if (item == null) {
                throw new OperationNotSupportedException("You can't pass null element!");
            }
            this.items.add(item);
        }
    }

    public boolean move() {
        if (!this.hasNext()) {
            return false;
        }

        this.internalIndex++;
        return true;
    }

    public boolean hasNext() {
        return this.internalIndex + 1 < this.items.size();
    }

    public T print() throws OperationNotSupportedException {
        if (this.items.isEmpty()) {
            throw new OperationNotSupportedException("Collection is empty!");
        }

        return this.items.get(this.internalIndex);
    }
}