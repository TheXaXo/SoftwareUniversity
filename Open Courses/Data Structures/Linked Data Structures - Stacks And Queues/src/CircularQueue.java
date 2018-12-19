public class CircularQueue<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private E[] items;
    private int startIndex;
    private int endIndex;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CircularQueue(int initialCapacity) {
        this.items = (E[]) new Object[initialCapacity];
        this.startIndex = 0;
        this.endIndex = 0;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(E element) {
        if (this.isFull()) {
            this.grow();
        }

        this.items[endIndex] = element;
        this.endIndex = (endIndex + 1) % this.items.length;
        this.size++;
    }

    public E dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }

        E removedItem = this.items[startIndex];
        this.startIndex = (this.startIndex + 1) % this.items.length;
        this.size--;

        return removedItem;
    }

    private boolean isFull() {
        return this.size >= this.items.length;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void grow() {
        this.items = this.toArray(this.size * 2);
        this.startIndex = 0;
        this.endIndex = this.size;
    }

    public E[] toArray() {
        return this.toArray(this.size);
    }

    @SuppressWarnings("unchecked")
    private E[] toArray(int newArraySize) {
        E[] newArray = (E[]) new Object[newArraySize];
        int indexInNewArr = 0;
        int startIndexInOldArr = this.startIndex;

        for (int i = 0; i < this.size; i++) {
            newArray[indexInNewArr++] = this.items[startIndexInOldArr];
            startIndexInOldArr = (startIndexInOldArr + 1) % this.items.length;
        }

        return newArray;
    }
}