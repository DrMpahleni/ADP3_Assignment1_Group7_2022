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

    public static Employee createEmployee( String firstName, String lastName) {

        if (genericHelper.isNullOrEmpty(firstName) || genericHelper.isNullOrEmpty(lastName))
            return null;

        int employeeId = genericHelper.generateIntId();

        Employee employee = new Employee.Builder().setEmployeeId(employeeId).
                                        setFirstName(firstName).
                                        setLastName(lastName).
                                        build();

                                        return employee;
    }
}
