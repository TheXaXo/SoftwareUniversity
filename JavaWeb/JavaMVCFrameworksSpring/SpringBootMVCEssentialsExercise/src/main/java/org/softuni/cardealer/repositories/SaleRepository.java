package org.softuni.cardealer.repositories;

import org.softuni.cardealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findById(long id);

    List<Sale> findAllByDiscountIsGreaterThan(double discount);

    List<Sale> findAllByDiscount(double discount);
}