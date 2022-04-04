/*
    EmployeeFactory.java
    factory for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(int employeeId, String firstName, String lastName) {

        Employee employee = new Employee.Builder().setEmployeeId(employeeId).
                                        setFirstName(firstName).
                                        setLastName(lastName).
                                        build();

                                        return employee;
    }
}
