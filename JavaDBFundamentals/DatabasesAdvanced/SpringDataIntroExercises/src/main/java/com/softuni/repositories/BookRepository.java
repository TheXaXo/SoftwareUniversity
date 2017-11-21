package com.softuni.repositories;

import com.softuni.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM books AS b WHERE YEAR(b.release_date) > 2000", nativeQuery = true)
    Set<Book> findAllAfterYear2000();
}