package za.ac.cput.repository.employee;

import za.ac.cput.entity.Employee;
import za.ac.cput.repository.employee.impl.IEmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class employeeRepository implements IEmployeeRepository {

    private static employeeRepository repository = null;
    private Set<Employee> employeeDB = null;

    private employeeRepository() {

        employeeDB = new HashSet<Employee>();
    }

    public static employeeRepository getRepository() {
        if (repository == null) {
            repository = new employeeRepository();
        }
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        boolean success = employeeDB.add(employee);
        if (!success)
            return null;
        return employee;
    }

    @Override
    public Employee read(String employeeId) {
        Employee employee = employeeDB.stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .findAny()
                .orElse(null);
        return employee;
    }

    @Override
    public Employee update(Employee employee){
        Employee oldEmployee = read(employee.getEmployeeId());
            if(oldEmployee != null) {
                employeeDB.remove(oldEmployee);
                employeeDB.add(employee);
                return employee;
            }
            return null;
    }

    @Override
    public boolean delete(String employeeId) {
        Employee employeeToDelete = read(employeeId);
            if(employeeToDelete == null)
                return false;
            employeeDB.remove(employeeToDelete);
        return true;
    }

    public Set<Employee> getAll(){

        return employeeDB;
    }

}
