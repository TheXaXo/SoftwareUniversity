import java.util.function.Consumer;

//2D Tree
public class KdTree {
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public boolean contains(Point2D point) {
        Node current = this.root;
        int depth = 0;

        while (current != null) {
            if (current.  point2D.equals(point)) {
                return true;
            }

            if (depth % 2 == 0) {
                if (point.getX() < current.getPoint2D().getX()) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            } else {
                if (point.getY() < current.getPoint2D().getY()) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            depth++;
        }

        return false;
    }

    public void insert(Point2D point) {
        this.root = this.insert(this.root, point, 0);
    }

    private Node insert(Node node, Point2D point2D, int depth) {
        if (node == null) {
            return new Node(point2D);
        }

        if (depth % 2 == 0) {
            if (point2D.getX() < node.point2D.getX()) {
                node.left = this.insert(node.left, point2D, depth + 1);
            } else {
                node.right = this.insert(node.right, point2D, depth + 1);
            }
        } else {
            if (point2D.getY() < node.point2D.getY()) {
                node.left = this.insert(node.left, point2D, depth + 1);
            } else {
                node.right = this.insert(node.right, point2D, depth + 1);
            }
        }

        return node;
    }

    public void eachInOrder(Consumer<Point2D> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<Point2D> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.getLeft(), consumer);
        consumer.accept(node.getPoint2D());
        this.eachInOrder(node.getRight(), consumer);
    }

    public class Node {
        private Point2D point2D;
        private Node left;
        private Node right;

        public Node(Point2D point) {
            this.setPoint2D(point);
        }

        public Point2D getPoint2D() {
            return this.point2D;
        }

        public void setPoint2D(Point2D point2D) {
            this.point2D = point2D;
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