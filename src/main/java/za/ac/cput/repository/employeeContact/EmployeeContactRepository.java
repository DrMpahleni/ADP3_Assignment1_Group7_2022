package za.ac.cput.repository.employeeContact;

import za.ac.cput.entity.EmployeeContact;

import java.util.HashSet;
import java.util.Set;

public class EmployeeContactRepository implements IEmployeeContactRepository {
    public static EmployeeContactRepository repository = null;
    public Set<EmployeeContact> employeeContactDB = null;

    private EmployeeContactRepository(){
        employeeContactDB = new HashSet<EmployeeContact>();
    }
    public static EmployeeContactRepository getRepository(){
        if(repository == null){
            repository = new EmployeeContactRepository();
        }
        return repository;
    }

    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        boolean  success = employeeContactDB.add(employeeContact);
        if(!success)
        return null;
        return employeeContact;
    }

    @Override
    public EmployeeContact read(String employeeId) {
        for(EmployeeContact e : employeeContactDB)
            if(e.getEmployeeId().equals(employeeId)){
                return e;
            }
        return null;
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        EmployeeContact oldEmployeeContact = read(employeeContact.getEmployeeId());
        if(oldEmployeeContact != null){
            employeeContactDB.remove(oldEmployeeContact);
            employeeContactDB.add(employeeContact);
            return employeeContact;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId) {
        EmployeeContact employeeContactDeleted = read(employeeId);
        if(employeeContactDeleted == null)
        return false;
        employeeContactDB.remove(employeeContactDeleted);
        return true;
    }

    @Override
    public Set<EmployeeContact> getAll() {
        return employeeContactDB;
    }
}
