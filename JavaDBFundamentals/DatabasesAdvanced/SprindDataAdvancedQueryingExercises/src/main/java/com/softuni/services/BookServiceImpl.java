package com.softuni.services;

import com.softuni.entities.Book;
import com.softuni.entities.ReducedBook;
import com.softuni.enums.AgeRestriction;
import com.softuni.enums.EditionType;
import com.softuni.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void printAllTitlesByAgeRestriction(String ageRestrictionStr) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionStr.toUpperCase());
        Set<Book> books = this.bookRepository.findAllByAgeRestriction(ageRestriction);

        books.forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllTitlesGoldenEditionAndLessThan5000Copies() {
        Set<Book> books = this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000);

        books.forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllTitlesPriceLessThan5AndGreaterThan40() {
        Set<Book> books = this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal("5.00"), new BigDecimal("40.00"));

        books.forEach(b -> System.out.println(b.getTitle() + " - $" + b.getPrice()));
    }

    @Override
    public void printAllTitlesNotReleasedInYear(int year) {
        Set<Book> books = this.bookRepository.findAllNotReleasedInYear(year);

        books.forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllTitlesReleasedBeforeDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(dateStr);

        Set<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);

        books.forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllTitlesContaining(String string) {
        Set<Book> books = this.bookRepository.findAllByTitleContaining(string);

        books.forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllByAuthorLastNameStartsWith(String prefix) {
        Set<Book> books = this.bookRepository.findAllByAuthorLastNameStartsWith(prefix);

        books.forEach(b -> System.out.printf("%s (%s %s)\n", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    @Override
    public void printCountTitleLengthMoreThan(int number) {
        System.out.println(this.bookRepository.countAllByTitleLongerThan(number));
    }

    @Override
    public void printBookByTitle(String title) {
        ReducedBook book = this.bookRepository.findByTitleEquals(title);

        System.out.printf("%s %s %s %s\n", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
    }

    @Override
    public void increaseCopiesOfBooksReleasedAfter(String dateStr, int amount) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        Date date = format.parse(dateStr);

        Set<Book> books = this.bookRepository.findAllByReleaseDateAfter(date);
        int totalCopiesAdded = 0;

        for (Book book : books) {
            this.bookRepository.increaseCopies(book.getId(), amount);
            totalCopiesAdded += amount;
        }

        System.out.println(totalCopiesAdded);
    }

    @Override
    public void deleteBooksWithCopiesLessThan(int number) {
        Set<Book> books = this.bookRepository.findAllByCopiesLessThan(number);
        int deletedCount = 0;

        for (Book book : books) {
            this.bookRepository.delete(book);
            deletedCount++;
        }

        System.out.println(deletedCount + " books were deleted");
    }
}