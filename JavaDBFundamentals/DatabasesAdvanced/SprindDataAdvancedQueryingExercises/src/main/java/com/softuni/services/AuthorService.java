package com.softuni.services;

import com.softuni.entities.Author;

public interface AuthorService {
    void save(Author author);

    void printAllNamesEndingWith(String suffix);

    void printAuthorsAndNumberOfCopiesOrdered();
}