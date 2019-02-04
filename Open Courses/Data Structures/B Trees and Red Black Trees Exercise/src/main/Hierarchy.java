package main;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {
    private Node root;
    private Map<T, Node> valuesNodes;

    public Hierarchy(T element) {
        this.root = new Node(element, null);
        valuesNodes = new LinkedHashMap<>();
        valuesNodes.put(element, this.root);
    }

    public void add(T parent, T child) {
        if (!this.valuesNodes.containsKey(parent) ||
                this.valuesNodes.containsKey(child)) {
            throw new IllegalArgumentException();
        }

        Node parentNode = this.valuesNodes.get(parent);
        Node newNode = new Node(child, parentNode);

        this.valuesNodes.put(child, newNode);
        parentNode.children.add(newNode);
    }

    public int getCount() {
        return this.valuesNodes.size();
    }

    public void remove(T element) {
        Node nodeToRemove = this.valuesNodes.get(element);

        if (nodeToRemove == null) {
            throw new IllegalArgumentException();
        }

        if (nodeToRemove.parent == null) {
            throw new IllegalStateException();
        }

        for (Node child : nodeToRemove.children) {
            child.parent = nodeToRemove.parent;
            nodeToRemove.parent.children.add(child);
        }

        nodeToRemove.parent.children.remove(nodeToRemove);
        this.valuesNodes.remove(element);

    }

    public boolean contains(T element) {
        return this.valuesNodes.containsKey(element);
    }

    @SuppressWarnings("unchecked")
    public T getParent(T element) {
        Node elementNode = this.valuesNodes.get(element);

        if (elementNode == null) {
            throw new IllegalArgumentException();
        }

        if (elementNode.parent == null) {
            return (T) Array.get(Array.newInstance(element.getClass(), 1), 0);
        }

        return elementNode.parent.value;
    }

    public Iterable<T> getChildren(T element) {
        Node elementNode = this.valuesNodes.get(element);

        if (element == null) {
            throw new IllegalArgumentException();
        }

        return elementNode.children.stream()
                .map(n -> n.value)
                .collect(Collectors.toList());
    }

    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        List<T> commonElements = new ArrayList<>();

        for (T key : this.valuesNodes.keySet()) {
            if (other.contains(key)) {
                commonElements.add(key);
            }
        }

        return commonElements;
    }

    @Override
    public Iterator<T> iterator() {
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(this.root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return queue.size() > 0;
            }

            @Override
            public T next() {
                Node element = queue.removeFirst();
                element.children.forEach(queue::addLast);

                return element.value;
            }
        };
    }

    class Node {
        private T value;
        private Node parent;
        private List<Node> children;

        Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }
}