package com.softuni;

import com.softuni.repositories.AuthorRepository;
import com.softuni.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public ConsoleRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
//        Book book = new Book("ASD", "ASD", EditionType.GOLD, 12, 20, new Date(), AgeRestriction.ADULT, this.authorRepository.findOne(1), new HashSet<>());
//        this.bookRepository.saveAndFlush(book);

        this.bookRepository.findAllAfterYear2000().forEach(b -> System.out.println(b.getTitle()));
    }
}