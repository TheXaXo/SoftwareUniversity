package com.softuni.services;

import com.softuni.entities.Book;

import java.text.ParseException;

public interface BookService {
    void save(Book book);

    void printAllTitlesByAgeRestriction(String ageRestrictionStr);

    void printAllTitlesGoldenEditionAndLessThan5000Copies();

    void printAllTitlesPriceLessThan5AndGreaterThan40();

    void printAllTitlesNotReleasedInYear(int year);

    void printAllTitlesReleasedBeforeDate(String dateStr) throws ParseException;

    void printAllTitlesContaining(String string);

    void printAllByAuthorLastNameStartsWith(String prefix);

    void printCountTitleLengthMoreThan(int number);

    void printBookByTitle(String title);

    void increaseCopiesOfBooksReleasedAfter(String dateStr, int amount) throws ParseException;

    void deleteBooksWithCopiesLessThan(int number);
}