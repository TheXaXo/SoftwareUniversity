package org.softuni.cardealer.repositories;

import org.softuni.cardealer.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    Part findById(long id);
}