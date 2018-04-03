package org.softuni.residentevil.services;

import org.softuni.residentevil.entities.Virus;
import org.softuni.residentevil.models.AddVirusBindingModel;
import org.softuni.residentevil.models.EditVirusBindingModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VirusService {
    void save(AddVirusBindingModel bindingModel);

    Page<Virus> findVirusesByPage(Pageable pageable);

    void deleteById(String id);

    Virus findVirusById(String id);

    void edit(String id, EditVirusBindingModel bindingModel);

    long getPagesCount(int pageSize);
}
