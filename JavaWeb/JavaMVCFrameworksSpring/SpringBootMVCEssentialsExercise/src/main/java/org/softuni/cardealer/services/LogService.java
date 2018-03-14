package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.Log;
import org.softuni.cardealer.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private LogRepository repository;

    @Autowired
    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    public List<Log> findAllByUser(String user) {
        return this.repository.findAllByUser(user);
    }

    public List<Log> findAll() {
        return this.repository.findAll();
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }

    public void save(Log log) {
        this.repository.saveAndFlush(log);
    }
}