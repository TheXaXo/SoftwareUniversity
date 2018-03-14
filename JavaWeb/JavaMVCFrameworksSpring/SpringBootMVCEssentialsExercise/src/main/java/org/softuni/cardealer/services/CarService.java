package org.softuni.cardealer.services;

import org.softuni.cardealer.entities.Car;
import org.softuni.cardealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getAllByMakeOrdered(String make) {
        return this.repository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make);
    }

    public List<Car> findAllCars() {
        return this.repository.findAll();
    }

    public Car findCarById(long id) {
        return this.repository.findCarById(id);
    }

    public void create(Car car) {
        this.repository.saveAndFlush(car);
    }

    public void update(Car car) {
        this.repository.saveAndFlush(car);
    }
}