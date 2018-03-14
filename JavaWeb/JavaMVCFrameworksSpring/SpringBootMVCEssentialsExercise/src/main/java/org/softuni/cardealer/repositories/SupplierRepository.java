package org.softuni.cardealer.repositories;

import org.softuni.cardealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> getAllByIsImporterTrue();

    List<Supplier> getAllByIsImporterFalse();

    Supplier findByName(String name);

    Supplier findById(long id);
}