import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {
    private ListNode<E> head;
    private ListNode<E> tail;

    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E element) {
        if (this.size == 0) {
            this.head = new ListNode<>(element);
            this.tail = this.head;
        } else {
            ListNode<E> newHead = new ListNode<>(element);

            this.head.setPrevNode(newHead);
            newHead.setNextNode(this.head);
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(E element) {
        if (this.size == 0) {
            this.head = new ListNode<>(element);
            this.tail = this.head;
        } else {
            ListNode<E> newTail = new ListNode<>(element);

            this.tail.setNextNode(newTail);
            newTail.setPrevNode(this.tail);
            this.tail = newTail;
        }

        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        ListNode<E> removedNode = this.head;

        this.head = this.head.getNextNode();

        if (head != null) {
            this.head.setPrevNode(null);
        } else {
            this.tail = null;
        }

        this.size--;

        return removedNode.getValue();
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        ListNode<E> removedNode = this.tail;

        this.tail = this.tail.getPrevNode();

        if (tail != null) {
            this.tail.setNextNode(null);
        } else {
            this.head = null;
        }

        this.size--;

        return removedNode.getValue();
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arrToReturn = (E[]) new Object[this.size];

        int index = 0;

        for (E element : this) {
            arrToReturn[index++] = element;
        }

        return arrToReturn;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            ListNode<E> element = head;

            @Override
            public boolean hasNext() {
                return element != null;
            }

            @Override
            public E next() {
                ListNode<E> elementToReturn = element;
                element = elementToReturn.getNextNode();

                return elementToReturn.getValue();
            }
        };
    }
}