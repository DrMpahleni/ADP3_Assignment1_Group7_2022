package za.ac.cput.repository.race;

/* IngredientsRepository.java
   This is an Ingredients Repository class
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.repository.race.impl.IEmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepository implements IEmployeeRaceRepository {
    private static EmployeeRaceRepository repository = null;
    private Set<EmployeeRace> employeeRaceDB = null;

    private EmployeeRaceRepository() {
        employeeRaceDB = new HashSet<EmployeeRace>();
    }
    public static EmployeeRaceRepository getRepository() {
        if(repository == null){
            repository = new EmployeeRaceRepository();
        }
        return repository;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        boolean success = employeeRaceDB.add(employeeRace);
        if(!success)
            return null;
        return employeeRace;
    }

    @Override
    public EmployeeRace read(Integer raceId) {
        EmployeeRace employeeRace = employeeRaceDB.stream()
                .filter(e -> e.getRaceId() == raceId)
                .findAny()
                .orElse(null);
        return employeeRace;
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        EmployeeRace oldEmployeeRace = read(employeeRace.getRaceId());
        if(oldEmployeeRace != null) {
            employeeRaceDB.remove(oldEmployeeRace);
            employeeRaceDB.add(employeeRace);
            return employeeRace;
        }
        return null;
    }

    @Override
    public boolean delete(Integer raceId) {
        EmployeeRace employeeRacetoDelete = read(raceId);
        if(employeeRacetoDelete == null)
            return false;
        employeeRaceDB.remove(employeeRacetoDelete);
        return true;
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return employeeRaceDB;
    }
}




