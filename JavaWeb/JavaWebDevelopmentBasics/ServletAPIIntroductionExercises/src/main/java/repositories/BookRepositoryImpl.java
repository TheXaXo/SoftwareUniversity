package repositories;

import entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private static BookRepositoryImpl bookRepository;
    private List<Book> books;

    private BookRepositoryImpl() {
        this.books = new ArrayList<>();
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepositoryImpl();
        }

        return bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public void deleteBookByTitle(String title) {
        this.books.stream()
                .filter(bookToDelete -> bookToDelete.getTitle().equals(title))
                .findFirst()
                .ifPresent(bookToDelete -> this.books.remove(bookToDelete));

    }

    @Override
    public Book findBookByTitle(String title) {
        return this.books.stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}