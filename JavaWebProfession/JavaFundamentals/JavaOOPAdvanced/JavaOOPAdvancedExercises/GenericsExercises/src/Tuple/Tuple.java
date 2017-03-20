package Tuple;

public class Tuple<O, T> {

    private O item1;
    private T item2;

    public Tuple(O item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public O getItem1() {
        return this.item1;
    }

    public T getItem2() {
        return this.item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getItem1(), this.getItem2());
    }
}