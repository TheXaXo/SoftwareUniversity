package com.softuni.repositories;

import com.softuni.entities.Book;
import com.softuni.entities.ReducedBook;
import com.softuni.enums.AgeRestriction;
import com.softuni.enums.EditionType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT * FROM books AS b WHERE YEAR(b.release_date) > 2000", nativeQuery = true)
    Set<Book> findAllAfterYear2000();

    Set<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    Set<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price1, BigDecimal price2);

    @Query(value = "SELECT * FROM books AS b WHERE YEAR(b.release_date) != :year", nativeQuery = true)
    Set<Book> findAllNotReleasedInYear(@Param(value = "year") int year);

    Set<Book> findAllByReleaseDateBefore(Date date);

    Set<Book> findAllByTitleContaining(String string);

    @Query("SELECT b FROM Book b WHERE b.author.lastName LIKE CONCAT(:prefix, '%')")
    Set<Book> findAllByAuthorLastNameStartsWith(@Param(value = "prefix") String prefix);

    @Query("SELECT COUNT(b) FROM Book b WHERE LENGTH(b.title) > :number")
    int countAllByTitleLongerThan(@Param(value = "number") int number);

    @Query("SELECT new com.softuni.entities.ReducedBook(b.title, b.editionType, b.ageRestriction, b.price) FROM Book b WHERE b.title = :title")
    ReducedBook findByTitleEquals(@Param(value = "title") String title);

    Set<Book> findAllByReleaseDateAfter(Date date);

    @Query("UPDATE Book b SET b.copies = b.copies + :amount WHERE b.id = :id")
    @Modifying
    @Transactional
    void increaseCopies(@Param(value = "id") int id, @Param(value = "amount") int amount);

    @Transactional
    Set<Book> findAllByCopiesLessThan(int number);
}