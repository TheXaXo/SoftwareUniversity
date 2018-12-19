import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    private int size;
    LinkedListNode<E> start;
    LinkedListNode<E> end;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
        LinkedListNode<E> newStart = new LinkedListNode<>(item);

        if (this.size == 0) {
            this.start = newStart;
            this.end = newStart;
        } else {
            newStart.setNextNode(this.start);
            this.start = newStart;
        }

        this.size++;
    }

    public void addLast(E item) {
        LinkedListNode<E> newEnd = new LinkedListNode<>(item);

        if (this.size == 0) {
            this.start = newEnd;
            this.end = newEnd;
        } else {
            this.end.setNextNode(newEnd);
            this.end = newEnd;
        }

        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new IllegalStateException();
        }

        LinkedListNode<E> removedNode = this.start;

        if (this.size == 1) {
            this.start = null;
            this.end = null;
        } else {
            this.start = removedNode.getNextNode();
        }

        this.size--;
        return removedNode.getValue();
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new IllegalStateException();
        }

        LinkedListNode<E> removedNode = this.end;

        if (this.size == 1) {
            this.start = null;
            this.end = null;
        } else {
            LinkedListNode<E> currentNode = this.start;

            while (true) {
                if (currentNode.getNextNode() == removedNode) {
                    this.end = currentNode;
                    this.end.setNextNode(null);

                    break;
                }

                currentNode = currentNode.getNextNode();
            }
        }

        this.size--;
        return removedNode.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedListNode<E> currentNode = start;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E valueToReturn = currentNode.getValue();
                currentNode = currentNode.getNextNode();

                return valueToReturn;
            }
        };
    }

    private class LinkedListNode<T> {
        private T value;
        private LinkedListNode<T> nextNode;

        private LinkedListNode(T value) {
            this.value = value;
        }

        private T getValue() {
            return this.value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        private LinkedListNode<T> getNextNode() {
            return this.nextNode;
        }

        private void setNextNode(LinkedListNode<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}