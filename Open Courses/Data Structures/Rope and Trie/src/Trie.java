import java.util.*;

public class Trie<T> {
    private Node root;

    public T getValue(String key) {
        Node result = this.getNode(this.root, key, 0);

        if (result == null || !result.isTerminal()) {
            throw new IllegalArgumentException();
        }

        return result.getValue();
    }

    public boolean contains(String key) {
        Node node = this.getNode(this.root, key, 0);
        return node != null && node.isTerminal();
    }

    public void insert(String key, T value) {
        this.root = this.insert(this.root, key, value, 0);
    }

    public Iterable<String> getByPrefix(String prefix) {
        Deque<String> result = new LinkedList<>();
        Node node = this.getNode(this.root, prefix, 0);

        this.collect(node, prefix, result);
        return reverseCollection(result);
    }

    private void collect(Node node, String prefix, Deque<String> result) {
        if (node == null) {
            return;
        }

        if (node.getValue() != null && node.isTerminal()) {
            result.addFirst(prefix);
        }

        for (Character c : node.getNext().keySet()) {
            this.collect(node.getNext().get(c), prefix + c, result);
        }
    }

    private Node insert(Node node, String key, T value, int v) {
        if (node == null) {
            Node newRoot = new Node();

            return this.insert(newRoot, key, value, v);
        }

        if (v == key.length()) {
            node.isTerminal = true;
            node.value = value;
            return node;
        }

        char c = key.charAt(v);
        Map<Character, Node> nodeChildren = node.getNext();

        if (nodeChildren.containsKey(c)) {
            this.insert(nodeChildren.get(c), key, value, v + 1);
        } else {
            Node nodeToInsert = new Node();
            node.getNext().put(key.charAt(v), nodeToInsert);

            this.insert(nodeToInsert, key, value, v + 1);
        }

        return node;
    }

    private Node getNode(Node node, String key, int v) {
        if (node == null) {
            return null;
        }

        if (v == key.length()) {
            return node;
        }

        char c = key.charAt(v);
        return this.getNode(node.getNext().get(c), key, v + 1);
    }

    private Iterable<String> reverseCollection(Deque<String> collection) {
        ArrayList<String> result = new ArrayList<>();

        Iterator<String> iterator = collection.descendingIterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        return result;
    }

    private class Node {
        private T value;
        private boolean isTerminal;
        private Map<Character, Node> next;

        public Node() {
            this.next = new LinkedHashMap<>();
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public boolean isTerminal() {
            return isTerminal;
        }

        public void setTerminal(boolean terminal) {
            this.isTerminal = terminal;
        }

        public Map<Character, Node> getNext() {
            return this.next;
        }
    }
}