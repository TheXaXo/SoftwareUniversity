package org.softuni.residentevil.services;

import org.softuni.residentevil.entities.Virus;
import org.softuni.residentevil.entities.enums.VirusMagnitude;
import org.softuni.residentevil.entities.enums.VirusMutation;
import org.softuni.residentevil.errors.VirusNotFoundException;
import org.softuni.residentevil.models.AddVirusBindingModel;
import org.softuni.residentevil.models.EditVirusBindingModel;
import org.softuni.residentevil.repositories.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirusServiceImpl implements VirusService {
    private VirusRepository repository;
    private CapitalServiceImpl capitalService;

    @Autowired
    public VirusServiceImpl(VirusRepository repository, CapitalServiceImpl capitalService) {
        this.repository = repository;
        this.capitalService = capitalService;
    }

    @Override
    public void save(AddVirusBindingModel bindingModel) {
        Virus virus = new Virus();

        virus.setName(bindingModel.getName());
        virus.setDescription(bindingModel.getDescription());
        virus.setSideEffects(bindingModel.getSideEffect());
        virus.setCreator(bindingModel.getCreator());
        virus.setDeadly(bindingModel.getIsDeadly() != null && bindingModel.getIsDeadly().equals("on"));
        virus.setCurable(bindingModel.getIsCurable() != null && bindingModel.getIsCurable().equals("on"));
        virus.setMutation(VirusMutation.valueOf(bindingModel.getMutation()));
        virus.setTurnoverRate(bindingModel.getTurnoverRate());
        virus.setHoursUntilTurn(bindingModel.getHoursUntilTurn());
        virus.setMagnitude(VirusMagnitude.valueOf(bindingModel.getMagnitude().toUpperCase()));
        virus.setReleasedOn(bindingModel.getReleaseDate());
        virus.setCapitals(new ArrayList<>());

        for (String capitalName : bindingModel.getAffectedCapitals()) {
            virus.getCapitals().add(this.capitalService.getCapitalByName(capitalName));
        }

        this.repository.saveAndFlush(virus);
    }

    @Override
    public Page<Virus> findVirusesByPage(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        Virus virus = this.repository.getOne(id);
        this.repository.delete(virus);
    }

    @Override
    public Virus findVirusById(String id) {
        return this.repository.findVirusById(id);
    }

    @Override
    public void edit(String id, EditVirusBindingModel bindingModel) {
        Virus virus = this.repository.findVirusById(id);

        if (virus == null) {
            throw new VirusNotFoundException();
        }

        virus.setName(bindingModel.getName());
        virus.setDescription(bindingModel.getDescription());
        virus.setSideEffects(bindingModel.getSideEffect());
        virus.setCreator(bindingModel.getCreator());
        virus.setDeadly(bindingModel.getIsDeadly() != null && bindingModel.getIsDeadly().equals("on"));
        virus.setCurable(bindingModel.getIsCurable() != null && bindingModel.getIsCurable().equals("on"));
        virus.setMutation(VirusMutation.valueOf(bindingModel.getMutation()));
        virus.setTurnoverRate(bindingModel.getTurnoverRate());
        virus.setHoursUntilTurn(bindingModel.getHoursUntilTurn());
        virus.setMagnitude(VirusMagnitude.valueOf(bindingModel.getMagnitude().toUpperCase()));
        virus.setCapitals(new ArrayList<>());

        for (String capitalName : bindingModel.getAffectedCapitals()) {
            virus.getCapitals().add(this.capitalService.getCapitalByName(capitalName));
        }

        this.repository.saveAndFlush(virus);
    }

    @Override
    public long getPagesCount(int pageSize) {
        return this.repository.count() / pageSize;
    }
}