import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IntervalTree {
    private Node root;

    public Interval searchAny(double lo, double hi) {
        Node current = this.root;

        while (current != null && !current.interval.intersects(lo, hi)) {
            if (current.left != null && current.left.max > lo) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return null;
        }

        return current.interval;
    }

    public Iterable<Interval> searchAll(double lo, double hi) {
        List<Interval> intervalList = new ArrayList<>();

        this.searchAll(this.root, intervalList, new Interval(lo, hi));

        return intervalList;
    }

    private void searchAll(Node node, List<Interval> intervalList, Interval interval) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.left.max > interval.getLo()) {
            this.searchAll(node.left, intervalList, interval);
        }

        if (node.interval.intersects(interval.getLo(), interval.getHi())) {
            intervalList.add(node.interval);
        }

        if (node.right != null && node.right.interval.getLo() < interval.getHi()) {
            this.searchAll(node.right, intervalList, interval);
        }
    }

    public void eachInOrder(Consumer<Interval> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<Interval> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.interval);
        this.eachInOrder(node.right, consumer);
    }

    public void insert(double lo, double hi) {
        this.root = this.insert(this.root, lo, hi);
    }

    private Node insert(Node node, double lo, double hi) {
        if (node == null) {
            return new Node(new Interval(lo, hi));
        }

        int cmp = Double.compare(lo, node.interval.getLo());
        if (cmp < 0) {
            node.left = insert(node.left, lo, hi);
        } else if (cmp > 0) {
            node.right = insert(node.right, lo, hi);
        }

        this.updateMaxInterval(node);

        return node;
    }

    private void updateMaxInterval(Node node) {
        double maxChildInterval = Double.MIN_VALUE;

        if (node.left != null) {
            maxChildInterval = node.left.max;
        }

        if (node.right != null && node.right.max > maxChildInterval) {
            maxChildInterval = node.right.max;
        }

        if (maxChildInterval > node.max) {
            node.max = maxChildInterval;
        }
    }

    private class Node {
        private Interval interval;
        private double max;
        private Node right;
        private Node left;

        Node(Interval interval) {
            this.interval = interval;
            this.max = interval.getHi();
        }
    }
}