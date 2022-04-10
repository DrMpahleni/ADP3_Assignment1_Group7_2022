package za.ac.cput.repository.employeeRace;

import za.ac.cput.entity.EmployeeRace;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepository implements IEmployeeRaceRepository {

    private static EmployeeRaceRepository repository = null;
    private Set<EmployeeRace> employeeRaceDB = null;

    private EmployeeRaceRepository() {

        employeeRaceDB = new HashSet<EmployeeRace>();
    }

    public static EmployeeRaceRepository getRepository() {
        if (repository == null) {
            repository = new EmployeeRaceRepository();
        }
        return repository;
    }


    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        return null;
    }

    @Override
    public EmployeeRace read(String s) {
        return null;
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Set<EmployeeRace> getAll() {
        return null;
    }
}
