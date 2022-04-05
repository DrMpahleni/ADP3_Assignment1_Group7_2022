package za.ac.cput.repository.employee.impl;

import za.ac.cput.entity.Employee;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeRepository extends IRepository<Employee, String> {

    public Set<Employee> getAll();
}
