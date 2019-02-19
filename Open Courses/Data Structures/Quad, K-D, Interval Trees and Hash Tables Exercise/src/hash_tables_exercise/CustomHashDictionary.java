package hash_tables_exercise;

import java.util.Iterator;

public class CustomHashDictionary<K, V> implements Iterable<KeyValue<K, V>> {
    private HashTable<K, V> hashTable;

    public CustomHashDictionary() {
        this.hashTable = new HashTable<>();
    }

    public void put(K key, V value) {
        this.hashTable.addOrReplace(key, value);
    }

    public boolean containsKey(K key) {
        return this.hashTable.containsKey(key);
    }

    public V get(K key) {
        return this.hashTable.get(key);
    }

    @Override
    public Iterator<KeyValue<K, V>> iterator() {
        return this.hashTable.iterator();
    }
}