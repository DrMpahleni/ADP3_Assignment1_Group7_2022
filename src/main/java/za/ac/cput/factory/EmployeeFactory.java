/*
    EmployeeFactory.java
    factory for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Employee;
import za.ac.cput.util.genericHelper;

public class EmployeeFactory {

    public static Employee createEmployee(int employeeId, String firstName, String lastName) {

        String employeeID = genericHelper.generateId();
        Employee employee = new Employee.Builder().setEmployeeId(employeeID).
                                        setFirstName(firstName).
                                        setLastName(lastName).
                                        build();

                                        return employee;
    }
}
