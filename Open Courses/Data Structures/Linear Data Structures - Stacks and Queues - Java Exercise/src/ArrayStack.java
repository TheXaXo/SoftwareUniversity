public class ArrayStack<T> {
    private static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;
    private int topIndex;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
        this.topIndex = 0;
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(T element) {
        if (this.size >= this.elements.length) {
            this.grow();
        }

        this.elements[this.topIndex++] = element;
        this.size++;
    }

    public T pop() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        T elementToReturn = this.elements[--this.topIndex];
        this.size--;

        return elementToReturn;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] elementsArray = (T[]) new Object[this.size];

        int indexInNewArr = 0;
        for (int i = this.size - 1; i >= 0; i--) {
            elementsArray[indexInNewArr++] = this.elements[i];
        }

        return elementsArray;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] newArray = (T[]) new Object[this.size * 2];

        System.arraycopy(this.elements, 0, newArray, 0, this.size);
        this.elements = newArray;
    }
}