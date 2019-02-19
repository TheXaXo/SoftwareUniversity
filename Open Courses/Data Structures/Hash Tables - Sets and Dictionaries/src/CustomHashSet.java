import java.util.Iterator;

public class CustomHashSet<T> implements Iterable<T> {
    private HashTable<T, T> table;

    public CustomHashSet() {
        this(null);
    }

    public CustomHashSet(Iterable<T> elements) {
        this.table = new HashTable<>();

        if (elements == null) {
            return;
        }

        for (T element : elements) {
            this.table.addOrReplace(element, element);
        }
    }

    public void add(T key) {
        this.table.addOrReplace(key, key);
    }

    public CustomHashSet<T> unionWith(CustomHashSet<T> other) {
        CustomHashSet<T> unionSet = new CustomHashSet<>();

        for (T element : this) {
            unionSet.add(element);
        }

        for (T element : other) {
            unionSet.add(element);
        }

        return unionSet;
    }

    public CustomHashSet<T> intersectWith(CustomHashSet<T> other) {
        CustomHashSet<T> intersectSet = new CustomHashSet<>();

        CustomHashSet<T> smallerSet = this.getSize() < other.getSize() ? this : other;
        CustomHashSet<T> largerSet = this.getSize() > other.getSize() ? this : other;

        for (T element : smallerSet) {
            if (largerSet.contains(element)) {
                intersectSet.add(element);
            }
        }

        return intersectSet;
    }

    public CustomHashSet<T> except(CustomHashSet<T> other) {
        CustomHashSet<T> exceptSet = new CustomHashSet<>();

        for (T element : this) {
            if (!other.contains(element)) {
                exceptSet.add(element);
            }
        }

        return exceptSet;
    }

    public CustomHashSet<T> symmetricalExcept(CustomHashSet<T> other) {
        return this.unionWith(other).except(this.intersectWith(other));
    }

    @Override
    public Iterator<T> iterator() {
        return this.table.keys().iterator();
    }

    public int getSize() {
        return this.table.size();
    }

    public boolean contains(T key) {
        return this.table.containsKey(key);
    }
}