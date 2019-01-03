import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree() {
    }

    private BinarySearchTree(Node node) {
        this.copy(node);
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node current = this.root;
        Node parent = null;

        while (current != null) {
            int compare = value.compareTo(current.value);
            parent = current;

            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else if (compare == 0) {
                return;
            }
        }

        if (value.compareTo(parent.value) > 0) {
            parent.right = new Node(value);
        } else {
            parent.left = new Node(value);
        }
    }

    public boolean contains(T value) {
        Node current = this.root;

        while (current != null) {
            int compare = value.compareTo(current.value);

            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;

        while (current != null) {
            int compare = item.compareTo(current.value);

            if (compare < 0) {
                current = current.left;
            } else if (compare > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return new BinarySearchTree<>(current);
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            this.eachInOrder(node.left, consumer);
        }

        consumer.accept(node.value);

        if (node.right != null) {
            this.eachInOrder(node.right, consumer);
        }
    }

    private void copy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.copy(node.left);
        this.copy(node.right);
    }

    public Iterable<T> range(T from, T to) {
        List<T> resultNodes = new ArrayList<>();

        this.range(resultNodes, this.root, from, to);

        return resultNodes;
    }

    private List<T> range(List<T> resultNodes, Node node, T from, T to) {
        if (node == null) {
            return resultNodes;
        }

        int compareLow = from.compareTo(node.value);
        int compareHigh = to.compareTo(node.value);

        if (compareLow < 0) {
            this.range(resultNodes, node.left, from, to);
        }

        if (compareLow <= 0 && compareHigh >= 0) {
            resultNodes.add(node.value);
        }

        if (compareHigh > 0) {
            this.range(resultNodes, node.right, from, to);
        }

        return resultNodes;
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}