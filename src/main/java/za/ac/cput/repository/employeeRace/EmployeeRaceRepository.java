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
        boolean success = employeeRaceDB.add(employeeRace);
        if(!success){
            return null;
        }
        return employeeRace;
    }

    @Override
    public EmployeeRace read(String s) {
        for (EmployeeRace e : employeeRaceDB) {
        }
        return null;
    }

    @Override

    public EmployeeRace update(EmployeeRace employeeRace) {
        EmployeeRace oldEmployeeRace = read(employeeRace.getRaceId());
        if(oldEmployeeRace != null){
            employeeRaceDB.remove(oldEmployeeRace);
            employeeRaceDB.add(employeeRace);
            return employeeRace;
        }

        return null;
    }

    @Override
    public boolean delete(String raceId) {
        EmployeeRace employeeRaceToDelete = read(raceId);
        if(employeeRaceToDelete == null){
            return false;
        }
        return true;
    }

    @Override
    public Set<EmployeeRace> getAll() {

        return null;
    }
}
