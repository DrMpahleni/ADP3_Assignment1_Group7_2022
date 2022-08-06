/*
    EmployeeRepository.java
    IEmployee for employee
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.Employee;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    public Set<Employee> getAll();
}
