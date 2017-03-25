package ListyIteratorExercise;

public class ListyIterator<T extends String> {

    private T[] items;
    private int currentIndex;

    public ListyIterator(T... items) {
        this.setItems(items);
        this.currentIndex = 0;
    }

    private void setItems(T... items) {
        this.items = items;
    }

    public boolean hasNext() {
        return this.items.length - 1 != this.currentIndex;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.items.length == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.items[this.currentIndex]);
    }
}