public class LinkedStack<E> {
    private Node<E> firstNode;
    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(E element) {
        Node<E> currentFirstNode = this.firstNode;
        Node<E> newFirstNode = new Node<>(element);

        this.firstNode = newFirstNode;
        newFirstNode.setNextNode(currentFirstNode);

        this.size++;
    }

    public E pop() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        Node<E> nodeToReturn = this.firstNode;
        this.firstNode = nodeToReturn.nextNode;

        this.size--;
        return nodeToReturn.value;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arrToReturn = (E[]) new Object[this.size];

        Node<E> currentNode = this.firstNode;
        int index = 0;

        while (currentNode != null) {
            arrToReturn[index++] = currentNode.value;
            currentNode = currentNode.nextNode;
        }

        return arrToReturn;
    }

    private class Node<T> {
        private T value;
        private Node<T> nextNode;

        public Node(T value) {
            this(value, null);
        }

        public Node(T value, Node<T> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public Node<T> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}