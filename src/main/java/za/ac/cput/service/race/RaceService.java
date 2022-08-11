package za.ac.cput.service.race;

/*
RaceService.java
@Author: Lihle Njobe(218193882)
Date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.race.Race;
import za.ac.cput.repository.race.RaceRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class RaceService implements IRaceService {

    private static RaceService service = null;

    @Autowired
    private RaceRepository repository;


    @Override
    public Race create(Race race) {

        return this.repository.save(race);
    }

    @Override
    public Optional<Race> read(Integer id) {

        return Optional.ofNullable(this.repository.findById(id).orElse(null));
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
    public Set<Race> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Race getEmployeeRaceGiven(String name) {
        Race r = null;
        Set<Race> races = getAll();
        for (Race race : races) {
            if (race.getName().equals(name)) {
                r = race;
                break;
            }
        }
        return r;
    }


}
