package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.Sale;
import org.softuni.cardealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private SaleRepository repository;

    @Autowired
    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public List<Sale> findAllSales() {
        return this.repository.findAll();
    }

    public Sale findSaleById(long id) {
        return this.repository.findById(id);
    }

    public List<Sale> findAllDiscountedSales() {
        return this.repository.findAllByDiscountIsGreaterThan(0);
    }

    public List<Sale> findAllByDiscount(double discount) {
        return this.repository.findAllByDiscount(discount);
    }

    public void save(Sale sale) {
        this.repository.save(sale);
    }
}