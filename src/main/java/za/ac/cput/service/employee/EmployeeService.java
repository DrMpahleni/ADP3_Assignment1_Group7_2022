/*
    EmployeeService.java
    Interface for Employee Service
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee, String> {

    List<Employee> getAll(String employeeId );
    void deleteById(String employeeId);
}
