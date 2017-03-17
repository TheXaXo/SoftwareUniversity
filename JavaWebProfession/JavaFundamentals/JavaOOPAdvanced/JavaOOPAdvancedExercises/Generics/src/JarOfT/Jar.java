package JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {

    private Deque<E> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(E element) {
        this.elements.push(element);
    }

    public E remove() {
        return this.elements.pop();
    }
}