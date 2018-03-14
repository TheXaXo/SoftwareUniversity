package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.Supplier;
import org.softuni.cardealer.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private SupplierRepository repository;

    @Autowired
    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> findAllImporterSuppliers() {
        return this.repository.getAllByIsImporterTrue();
    }

    public List<Supplier> findAllLocalSuppliers() {
        return this.repository.getAllByIsImporterFalse();
    }

    public List<Supplier> findAllSuppliers() {
        return this.repository.findAll();
    }

    public Supplier findOneByName(String name) {
        return this.repository.findByName(name);
    }

    public void save(Supplier supplier) {
        this.repository.saveAndFlush(supplier);
    }

    public void delete(Supplier supplier) {
        this.repository.delete(supplier);
    }

    public Supplier findOneById(long id) {
        return repository.findById(id);
    }

    public void update(Supplier supplier) {
        this.repository.saveAndFlush(supplier);
    }
}