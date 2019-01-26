public class Heap {

    public static <E extends Comparable<E>> void sort(E[] array) {
        if (array.length == 0) {
            return;
        }

        buildMaxHeap(array);
        sort(array, array.length);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int remainingItemsToSortCount) {
        if (remainingItemsToSortCount == 0) {
            return;
        }

        swap(0, --remainingItemsToSortCount, array);
        heapifyDown(0, array, remainingItemsToSortCount);

        sort(array, remainingItemsToSortCount);
    }

    private static <E extends Comparable<E>> void buildMaxHeap(E[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            heapifyDown(i, array, array.length);
        }
    }

    private static <E extends Comparable<E>> void heapifyDown(int elementIndex, E[] array, int arrayLength) {
        if (arrayLength == 0) {
            return;
        }

        E element = array[elementIndex];

        int leftChildIndex = 2 * elementIndex + 1;

        if (leftChildIndex < arrayLength) {
            E leftChild = array[leftChildIndex];
            E childToCompareWith = leftChild;
            int childToCompareWithIndex = leftChildIndex;

            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex < arrayLength) {
                E rightChild = array[rightChildIndex];

                if (rightChild.compareTo(leftChild) > 0) {
                    childToCompareWith = rightChild;
                    childToCompareWithIndex = rightChildIndex;
                }
            }

            int compare = childToCompareWith.compareTo(element);

            if (compare > 0) {
                swap(elementIndex, childToCompareWithIndex, array);
                heapifyDown(childToCompareWithIndex, array, arrayLength);
            }
        }
    }

    private static <T> void swap(int element1Index, int element2Index, T[] array) {
        T temp = array[element2Index];
        array[element2Index] = array[element1Index];
        array[element1Index] = temp;
    }
}