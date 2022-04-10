package za.ac.cput.repository.employeeGender;

import za.ac.cput.entity.EmployeeGender;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepository implements IEmployeeGenderRepository {
    public static EmployeeGenderRepository repository = null;
    public Set<EmployeeGender> employeeGenderDB = null;

    private EmployeeGenderRepository() {
        employeeGenderDB = new HashSet<EmployeeGender>();
    }

    public static EmployeeGenderRepository getRepository() {
        if (repository == null) {
            repository = new EmployeeGenderRepository();
        }
        return repository;
    }


    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        boolean success = employeeGenderDB.add(employeeGender);
        if (!success)
            return null;
        return employeeGender;
    }

    @Override
    public EmployeeGender read(String employeeId) {
        for (EmployeeGender g : employeeGenderDB)
            if (g.getEmployeeId().equals(employeeId)) {
                return g;
            }
        return null;
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        EmployeeGender oldEmployeeGender = read(employeeGender.getEmployeeId());
        if(oldEmployeeGender != null){
            employeeGenderDB.remove(oldEmployeeGender);
            employeeGenderDB.add(employeeGender);
            return employeeGender;
        }
        return null;
    }


    @Override
    public boolean delete(String employeeId) {
        EmployeeGender employeeGenderDeleted = read(employeeId);
        if (employeeGenderDeleted == null)
            return false;
        employeeGenderDB.remove(employeeGenderDeleted);
        return true;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return employeeGenderDB;
    }
}