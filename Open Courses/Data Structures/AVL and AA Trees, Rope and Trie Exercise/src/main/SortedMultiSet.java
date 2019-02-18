package main;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @param <Type>
 * @author Marc Woerlein (woerlein@informatik.uni-erlangen.de)
 */
public class SortedMultiSet<Type extends Comparable<Type>> implements
        Collection<Type>, Comparable<SortedMultiSet<Type>> {

    Type[] field;
    Comparator<? super Type> comparator;
    int size;

    @SuppressWarnings("unchecked")
    public SortedMultiSet(Comparator<? super Type> comparator) {
        size = 0;
        field = (Type[]) new Comparable[4];
        this.comparator = comparator;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#add(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public boolean add(final Type o) {
        if (o == null) {
            return false;
        }
        Type[] destField = field;
        int pos = 0;
        // skip smaller ones
        while (pos < size && this.comparator.compare(field[pos], o) >= 0) {
            pos++;
        }
        if (size == field.length) {
            // copy smaller ones
            System.arraycopy(field, 0,
                    destField = (Type[]) new Comparable[(int) (size * 1.5)], 0,
                    pos);
        }
        // move bigger ones
        System.arraycopy(field, pos, destField, pos + 1, size - pos);
        // insert value
        destField[pos] = o;
        field = destField;
        size++;
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#addAll(java.util.Collection)
     */
    public boolean addAll(final Collection<? extends Type> c) {
        boolean ret = false;
        for (final Type t : c) {
            ret |= add(t);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#clear()
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        field = (Type[]) new Comparable[field.length];
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(final SortedMultiSet<Type> o) {
        int c = 0;
        int i = 0;
        while (c == 0) {
            if (i == size) {
                return i == o.size ? 0 : -1;
            }
            if (i == o.size) {
                return 1;
            }
            c = this.comparator.compare(field[i], o.field[i]);
            i++;
        }
        return c;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#contains(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public boolean contains(final Object o) {
        return (o instanceof Comparable) && pos((Type) o) >= 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#containsAll(java.util.Collection)
     */
    public boolean containsAll(final Collection<?> c) {
        boolean ret = true;
        for (final Object t : c) {
            ret &= contains(t);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof SortedMultiSet
                && compareTo((SortedMultiSet) obj) == 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return size();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#isEmpty()
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#iterator()
     */
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            int idx = 0;

            public boolean hasNext() {
                return idx < size;
            }

            public Type next() {
                if (hasNext()) {
                    return field[idx++];
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    private int pos(final Type t) {
        int c = -1;
        int pos = 0;
        for (; c != 0 && pos < size; pos++) {
            c = this.comparator.compare(field[pos], t);
        }
        return c == 0 ? pos - 1 : -1;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#remove(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public boolean remove(final Object o) {
        if (o instanceof Comparable) {
            final int pos = pos((Type) o);
            if (pos >= 0) {
                this.removePos(pos);
                return true;
            }
        }
        return false;
    }

    private void removePos(int pos) {
        System.arraycopy(field, pos + 1, field, pos, --size - pos);
    }

    @SuppressWarnings("unchecked")
    public int removeAllCopies(final Object o) {
        int count = 0;
        int pos = pos((Type) o);

        while (pos >= 0) {
            this.removePos(pos);
            pos = pos((Type) o);

            count++;
        }

        return count;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#removeAll(java.util.Collection)
     */
    public boolean removeAll(final Collection<?> c) {
        boolean ret = false;
        for (final Object t : c) {
            ret |= remove(t);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#retainAll(java.util.Collection)
     */
    public boolean retainAll(final Collection<?> c) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (c.contains(field[i])) {
                field[j++] = field[i];
            }
        }
        if (j == size) {
            return false;
        }
        for (; j < size; j++) {
            field[j] = null;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#size()
     */
    public int size() {
        return size;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#toArray()
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        return toArray((Type[]) new Comparable[size]);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Collection#toArray(T[])
     */
    public <T> T[] toArray(final T[] a) {
        System.arraycopy(field, 0, a, 0, size);
        return a;
    }
}