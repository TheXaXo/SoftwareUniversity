package com.softuni.repositories;

import com.softuni.entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Set<Author> findAllByFirstNameEndsWith(String suffix);

    @Query(value = "SELECT CONCAT(a.first_name, ' ', a.last_name) AS full_name, SUM(b.copies) AS total_copies FROM books AS b JOIN authors AS a ON b.author_id = a.id GROUP BY b.author_id ORDER BY total_copies DESC", nativeQuery = true)
    Set<Object[]> getAuthorsAndNumberOfCopiesOrdered();
}