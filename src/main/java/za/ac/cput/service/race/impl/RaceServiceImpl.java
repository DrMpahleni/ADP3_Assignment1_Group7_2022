package za.ac.cput.service.race.impl;

/*
RaceService.java
@Author: Lihle Njobe(218193882)
Date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.race.Race;
import za.ac.cput.repository.race.RaceRepository;
import za.ac.cput.service.race.IRaceService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class RaceServiceImpl implements IRaceService {

    private RaceRepository repository;

    public RaceServiceImpl(RaceRepository repository) {
        this.repository = repository;
    }

    public RaceServiceImpl() {

    }

    @Override
    public Race create(Race race) {

        return this.repository.save(race);
    }

    @Override
    public Optional<Race> read(Integer id) {

        return repository.findById(id);
    }

    @Override
    public Race update(Race race) {
        if (this.repository.existsById(race.getId()))
            return this.repository.save(race);
        return null;
    }

    @Override
    public void delete(Race race) {
        this.repository.delete(race);

    }

    @Override
    public void deleteById(Integer id) {
        Optional<Race> race = read(id);
        if(race.isPresent()) delete(race.get());

    }

    @Override
    public List<Race> getAll(Integer id) {
        return repository.findAll();
    }
}
