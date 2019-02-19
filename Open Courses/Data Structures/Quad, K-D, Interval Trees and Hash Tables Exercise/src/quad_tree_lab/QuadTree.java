package quad_tree_lab;

import java.util.ArrayList;
import java.util.List;

public class QuadTree<T extends Boundable> {
    public static final int DEFAULT_MAX_DEPTH = 5;

    private int maxDepth;
    private Node<T> root;
    private Rectangle bounds;
    private int count;

    public QuadTree(int width, int height) {
        this(width, height, DEFAULT_MAX_DEPTH);
    }

    public QuadTree(int width, int height, int maxDepth) {
        this.root = new Node<T>(0, 0, width, height);
        this.bounds = this.root.getBounds();
        this.maxDepth = maxDepth;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    private void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getCount() {
        return this.count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public boolean insert(T item) {
        Rectangle itemBounds = item.getBounds();
        Node<T> current = this.root;
        int depth = 1;

        if (!itemBounds.isInside(current.getBounds())) {
            return false;
        }

        while (current != null) {
            int quadrant = this.getQuadrant(current, itemBounds);

            if (quadrant == -1) {
                break;
            }

            current = current.getChildren()[quadrant];
            depth++;
        }

        current.getItems().add(item);
        this.trySplitNode(current, depth);

        this.count++;
        return true;
    }

    private int getQuadrant(Node<T> node, Rectangle itemBounds) {
        Node<T>[] quadrants = node.getChildren();

        if (quadrants == null) {
            return -1;
        }

        for (int i = 0; i < Node.MAX_ITEM_COUNT; i++) {
            if (itemBounds.isInside(quadrants[i].getBounds())) {
                return i;
            }
        }

        return -1;
    }

    private void trySplitNode(Node<T> node, int depth) {
        if (!node.shouldSplit() || depth >= this.maxDepth) {
            return;
        }

        Rectangle nodeBounds = node.getBounds();

        Node<T> upperLeft = new Node<>(
                nodeBounds.getX1(),
                nodeBounds.getY1(),
                nodeBounds.getWidth() / 2,
                nodeBounds.getHeight() / 2
        );

        Node<T> upperRight = new Node<>(
                nodeBounds.getMidX(),
                nodeBounds.getY1(),
                nodeBounds.getWidth() / 2,
                nodeBounds.getHeight() / 2
        );

        Node<T> bottomLeft = new Node<>(
                nodeBounds.getX1(),
                nodeBounds.getMidY(),
                nodeBounds.getWidth() / 2,
                nodeBounds.getHeight() / 2
        );

        Node<T> bottomRight = new Node<>(
                nodeBounds.getMidX(),
                nodeBounds.getMidY(),
                nodeBounds.getWidth() / 2,
                nodeBounds.getHeight() / 2
        );

        node.setChildren(new Node[Node.MAX_ITEM_COUNT]);

        node.getChildren()[0] = upperRight;
        node.getChildren()[1] = upperLeft;
        node.getChildren()[2] = bottomLeft;
        node.getChildren()[3] = bottomRight;

        List<T> tempItems = new ArrayList<>(node.getItems());

        for (T item : tempItems) {
            for (Node<T> quadrant : node.getChildren()) {
                if (item.getBounds().isInside(quadrant.getBounds())) {
                    quadrant.getItems().add(item);
                    node.getItems().remove(item);

                    this.trySplitNode(quadrant, depth + 1);

                    break;
                }
            }
        }
    }

    public List<T> report(Rectangle bounds) {
        if (!bounds.isInside(this.root.getBounds())) {
            return null;
        }

        List<T> items = new ArrayList<>();
        this.reportCollisions(this.root, items, bounds);

        return items;
    }

    private void reportCollisions(Node<T> node, List<T> collisions, Rectangle bounds) {
        int quadrant = this.getQuadrant(node, bounds);

        if (quadrant == -1) {
            this.getAllIntersecting(node, bounds, collisions);
        } else {
            this.reportCollisions(node.getChildren()[quadrant], collisions, bounds);

            for (T item : node.getItems()) {
                if (bounds.intersects(item.getBounds())) {
                    collisions.add(item);
                }
            }
        }
    }

    private void getAllIntersecting(Node<T> node, Rectangle bounds, List<T> result) {
        for (T item : node.getItems()) {
            if (item.getBounds().intersects(bounds)) {
                result.add(item);
            }
        }

        if (node.getChildren() == null) {
            return;
        }

        for (Node<T> quadrant : node.getChildren()) {
            if (quadrant.getBounds().intersects(bounds)) {
                this.getAllIntersecting(quadrant, bounds, result);
            }
        }
    }
}