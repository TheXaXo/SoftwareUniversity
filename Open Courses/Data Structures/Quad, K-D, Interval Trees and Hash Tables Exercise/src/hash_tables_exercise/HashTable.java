package hash_tables_exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashTable<TKey, TValue> implements Iterable<KeyValue<TKey, TValue>> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.7F;

    LinkedList<KeyValue<TKey, TValue>>[] elements;
    private int size;
    private int capacity;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.elements = new LinkedList[capacity];
        this.capacity = capacity;
    }

    public void add(TKey key, TValue value) {
        KeyValue<TKey, TValue> pair = new KeyValue<>(key, value);

        int index = Math.abs(key.hashCode()) % this.capacity;

        if (this.elements[index] == null) {
            this.elements[index] = new LinkedList<>();
        }

        if (this.containsKey(this.elements[index], key)) {
            throw new IllegalArgumentException();
        }

        this.elements[index].addLast(pair);
        this.size++;
        this.growIfNeeded();
    }

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean addOrReplace(TKey key, TValue value) {
        int index = Math.abs(key.hashCode()) % this.capacity;
        KeyValue<TKey, TValue> pair = this.find(key);

        boolean isReplaced = false;

        if (pair == null) {
            if (this.elements[index] == null) {
                this.elements[index] = new LinkedList<>();
            }

            this.elements[index].addLast(new KeyValue<>(key, value));
            this.size++;
            this.growIfNeeded();
        } else {
            pair.setValue(value);
            isReplaced = true;
        }

        return isReplaced;
    }

    public TValue get(TKey key) {
        KeyValue<TKey, TValue> pair = this.find(key);

        if (pair == null) {
            throw new IllegalArgumentException();
        }

        return pair.getValue();
    }

    //Broken
    public boolean tryGetValue(TKey key, TValue value) {
        KeyValue<TKey, TValue> pair = this.find(key);

        if (pair == null) {
            return false;
        }

        value = pair.getValue();
        return true;
    }

    public KeyValue<TKey, TValue> find(TKey key) {
        int index = Math.abs(key.hashCode()) % this.capacity;

        if (this.elements[index] == null) {
            return null;
        }

        for (KeyValue<TKey, TValue> pair : this.elements[index]) {
            if (pair.getKey().equals(key)) {
                return pair;
            }
        }

        return null;
    }

    public boolean containsKey(TKey key) {
        int index = Math.abs(key.hashCode()) % this.capacity;

        if (this.elements[index] != null) {
            return this.containsKey(this.elements[index], key);
        }

        return false;
    }

    private boolean containsKey(LinkedList<KeyValue<TKey, TValue>> elements, TKey key) {
        for (KeyValue<TKey, TValue> pair : elements) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    public boolean remove(TKey key) {
        KeyValue<TKey, TValue> pairToRemove = this.find(key);

        if (pairToRemove == null) {
            return false;
        }

        int index = Math.abs(key.hashCode()) % this.capacity;

        LinkedList<KeyValue<TKey, TValue>> list = this.elements[index];
        list.remove(pairToRemove);

        if (list.size() == 0) {
            this.elements[index] = null;
        }

        this.size--;

        return true;
    }

    public void clear() {
        this.elements = new LinkedList[DEFAULT_CAPACITY];
    }

    public Iterable<TKey> keys() {
        List<TKey> keys = new ArrayList<>();

        for (LinkedList<KeyValue<TKey, TValue>> list : this.elements) {
            if (list == null) {
                continue;
            }

            for (KeyValue<TKey, TValue> pair : list) {
                keys.add(pair.getKey());
            }
        }

        return keys;
    }

    public Iterable<TValue> values() {
        List<TValue> values = new ArrayList<>();

        for (LinkedList<KeyValue<TKey, TValue>> list : this.elements) {
            if (list == null) {
                continue;
            }

            for (KeyValue<TKey, TValue> pair : list) {
                values.add(pair.getValue());
            }
        }

        return values;
    }

    @Override
    public Iterator<KeyValue<TKey, TValue>> iterator() {
        List<KeyValue<TKey, TValue>> pairs = new ArrayList<>();

        for (LinkedList<KeyValue<TKey, TValue>> list : this.elements) {
            if (list == null) {
                continue;
            }

            pairs.addAll(list);
        }

        return pairs.iterator();
    }

    private void growIfNeeded() {
        float currentLoad = this.size / (float) this.capacity;

        if (currentLoad < LOAD_FACTOR) {
            return;
        }

        LinkedList<KeyValue<TKey, TValue>>[] temp = this.elements;
        this.capacity *= 2;
        this.elements = new LinkedList[this.capacity];
        this.size = 0;

        for (LinkedList<KeyValue<TKey, TValue>> list : temp) {
            if (list == null) {
                continue;
            }

            for (KeyValue<TKey, TValue> pair : list) {
                this.add(pair.getKey(), pair.getValue());
            }
        }
    }
}