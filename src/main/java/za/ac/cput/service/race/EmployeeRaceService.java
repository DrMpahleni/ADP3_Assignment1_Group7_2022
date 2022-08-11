package za.ac.cput.service.race;

/*
EmployeeRaceService.java
@Author: Lihle Njobe(218193882)
Date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.repository.race.EmployeeRaceRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeRaceService implements IEmployeeRaceService {
    private static EmployeeRaceService service = null;

    @Autowired
    private EmployeeRaceRepository repository;


    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {

        return this.repository.save(employeeRace);
    }

    @Override
    public Optional<EmployeeRace> read(Integer raceId) {
        return Optional.ofNullable(this.repository.findById(raceId).orElse(null));
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
    public Set<EmployeeRace> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public EmployeeRace getEmployeeRaceGiven(String raceName) {
        EmployeeRace e = null;
        Set<EmployeeRace> employeeRaces = getAll();
        for (EmployeeRace employeeRace : employeeRaces) {
            if (employeeRace.getRaceName().equals(raceName)) {
                e = employeeRace;
                break;
            }
        }
        return e;
    }
}

