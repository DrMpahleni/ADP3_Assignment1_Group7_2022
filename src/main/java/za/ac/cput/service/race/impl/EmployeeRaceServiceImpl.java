package za.ac.cput.service.race.impl;

/*
EmployeeRaceService.java
@Author: Lihle Njobe(218193882)
Date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.repository.race.EmployeeRaceRepository;
import za.ac.cput.repository.race.RaceRepository;
import za.ac.cput.service.race.IEmployeeRaceService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeRaceServiceImpl implements IEmployeeRaceService {

    private EmployeeRaceRepository repository;

    public EmployeeRaceServiceImpl(EmployeeRaceRepository repository) {

        this.repository = repository;
    }

    public EmployeeRaceServiceImpl() {

    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {

        return this.repository.save(employeeRace);
    }

    @Override
    public Optional<EmployeeRace> read(Integer raceId) {
        return repository.findById(raceId);
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        if (this.repository.existsById(employeeRace.getRaceId()))
            return this.repository.save(employeeRace);
        return null;
    }

    @Override
    public void delete(EmployeeRace employeeRace) {
        this.repository.delete(employeeRace);

    }

    @Override
    public List<EmployeeRace> getAll(Integer raceId) {

        return repository.findAll();
    }

    @Override
    public void deleteById(Integer raceId) {
        Optional<EmployeeRace> employeeRace = read(raceId);
        if (employeeRace.isPresent()) delete(employeeRace.get());

    }
}

