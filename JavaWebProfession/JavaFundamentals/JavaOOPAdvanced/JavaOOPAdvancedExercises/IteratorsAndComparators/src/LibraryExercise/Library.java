package LibraryExercise;

import java.util.Iterator;

public class Library<B extends Book> implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.setBooks(books);
    }

    public void setBooks(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {
        private int currentIndex;

        private LibIterator() {
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < books.length;
        }

        @Override
        public Book next() {
            return books[currentIndex++];
        }
    }
}