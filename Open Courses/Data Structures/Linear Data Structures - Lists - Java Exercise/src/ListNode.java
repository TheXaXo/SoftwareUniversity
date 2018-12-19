public class ListNode<T> {
    private T value;
    private ListNode<T> nextNode;
    private ListNode<T> prevNode;

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public ListNode<T> getPrevNode() {
        return this.prevNode;
    }

    public void setPrevNode(ListNode<T> prevNode) {
        this.prevNode = prevNode;
    }
}