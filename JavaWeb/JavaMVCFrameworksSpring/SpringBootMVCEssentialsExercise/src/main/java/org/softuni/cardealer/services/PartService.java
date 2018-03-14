package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.Part;
import org.softuni.cardealer.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {
    private PartRepository repository;

    @Autowired
    public PartService(PartRepository repository) {
        this.repository = repository;
    }

    public void create(Part part) {
        this.repository.saveAndFlush(part);
    }

    public List<Part> findAll() {
        return this.repository.findAll();
    }

    public Part findPartById(long id) {
        return this.repository.findById(id);
    }

    public void delete(Part part) {
        this.repository.delete(part);
    }

    public void update(Part part) {
        this.repository.saveAndFlush(part);
    }
}