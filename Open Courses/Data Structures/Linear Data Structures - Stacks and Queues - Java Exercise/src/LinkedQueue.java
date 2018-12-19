public class LinkedQueue<E> {
    private int size;
    private QueueNode<E> startNode;
    private QueueNode<E> endNode;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        QueueNode<E> newEndNode = new QueueNode<>(element);

        if (this.endNode != null) {
            this.endNode.setNextNode(newEndNode);
            newEndNode.setPrevNode(this.endNode);
        } else {
            this.startNode = newEndNode;
        }

        this.endNode = newEndNode;
        this.size++;
    }

    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        QueueNode<E> nodeToReturn = this.startNode;
        this.startNode = nodeToReturn.getNextNode();

        if (this.startNode == null) {
            this.endNode = null;
        }

        this.size--;
        return nodeToReturn.value;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arrToReturn = (E[]) new Object[this.size];

        QueueNode<E> currentNode = this.startNode;
        int index = 0;

        while (currentNode != null) {
            arrToReturn[index++] = currentNode.value;
            currentNode = currentNode.nextNode;
        }

        return arrToReturn;
    }

    private class QueueNode<T> {
        private T value;
        private QueueNode<T> nextNode;
        private QueueNode<T> prevNode;

        public QueueNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        public QueueNode<T> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(QueueNode<T> nextNode) {
            this.nextNode = nextNode;
        }

        public QueueNode<T> getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(QueueNode<T> prevNode) {
            this.prevNode = prevNode;
        }
    }
}