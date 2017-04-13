package database;

import contracts.Repository;
import models.boats.Boat;
import models.engines.BoatEngine;

public class Database {
    private Repository<Boat> boatsRepository;
    private Repository<BoatEngine> enginesRepository;

    @SuppressWarnings("unchecked")
    public Database() {
        this.setBoatsRepository(new RepositoryImpl<>());
        this.setEnginesRepository(new RepositoryImpl<>());
    }

    public Repository<Boat> getBoatsRepository() {
        return this.boatsRepository;
    }

    private void setBoatsRepository(Repository<Boat> boatsRepository) {
        this.boatsRepository = boatsRepository;
    }

    public Repository<BoatEngine> getEnginesRepository() {
        return this.enginesRepository;
    }

    private void setEnginesRepository(Repository<BoatEngine> enginesRepository) {
        this.enginesRepository = enginesRepository;
    }
}