import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {

    private List<T> heap;
    private int size;

    public BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    public int size() {
        return this.size;
    }

    public void insert(T element) {
        this.heap.add(element);
        this.heapifyUp(this.size);
        this.size++;
    }

    private void heapifyUp(int elementIndex) {
        T element = this.heap.get(elementIndex);
        int parentElementIndex = (elementIndex - 1) / 2;

        if (parentElementIndex < 0) {
            return;
        }

        T parent = this.heap.get(parentElementIndex);
        int compare = element.compareTo(parent);

        if (compare > 0) {
            this.swap(elementIndex, parentElementIndex);
        } else {
            return;
        }

        this.heapifyUp(parentElementIndex);
    }

    private void swap(int element1Index, int element2Index) {
        T element1 = this.heap.get(element1Index);
        T element2 = this.heap.get(element2Index);

        this.heap.set(element1Index, element2);
        this.heap.set(element2Index, element1);
    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        return this.heap.get(0);
    }

    public T pull() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        T item = this.heap.get(0);

        this.swap(0, this.size - 1);
        this.heap.remove(this.size - 1);
        this.size--;
        this.heapifyDown(0);

        return item;
    }

    private void heapifyDown(int elementIndex) {
        if (this.heap.size() == 0) {
            return;
        }

        T element = this.heap.get(elementIndex);

        int leftChildIndex = 2 * elementIndex + 1;

        if (leftChildIndex < this.size) {
            T leftChild = this.heap.get(leftChildIndex);
            T childToCompareWith = leftChild;
            int childToCompareWithIndex = leftChildIndex;

            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex < this.size) {
                T rightChild = this.heap.get(rightChildIndex);

                if (rightChild.compareTo(leftChild) > 0) {
                    childToCompareWith = rightChild;
                    childToCompareWithIndex = rightChildIndex;
                }
            }

            int compare = childToCompareWith.compareTo(element);

            if (compare > 0) {
                this.swap(elementIndex, childToCompareWithIndex);
                this.heapifyDown(childToCompareWithIndex);
            }
        }
    }
}