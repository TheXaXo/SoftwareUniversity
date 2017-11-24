package com.softuni.services;

import com.softuni.entities.Author;
import com.softuni.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public void printAllNamesEndingWith(String suffix) {
        Set<Author> authors = this.authorRepository.findAllByFirstNameEndsWith(suffix);

        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    @Override
    public void printAuthorsAndNumberOfCopiesOrdered() {
        Set<Object[]> authorsCopies = this.authorRepository.getAuthorsAndNumberOfCopiesOrdered();

        authorsCopies.forEach(ac -> System.out.printf("%s - %s\n", ac[0], ac[1]));
    }
}