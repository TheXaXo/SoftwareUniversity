package hash_tables_exercise;

import java.util.Iterator;

public class OrderedSet<T extends Comparable<T>> implements Iterable<T> {
    private RedBlackBST<T> tree;

    public OrderedSet() {
        this.tree = new RedBlackBST<T>();
    }

    public void add(T element) {
        this.tree.put(element);
    }

    public boolean contains(T element) {
        return this.tree.contains(element);
    }

    public void remove(T element) {
        this.tree.delete(element);
    }

    public int count() {
        return this.tree.size();
    }

    @Override
    public Iterator<T> iterator() {
        return this.tree.keys().iterator();
    }
}