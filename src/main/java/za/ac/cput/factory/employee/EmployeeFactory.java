/*
    EmployeeFactory.java
    factory for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory.employee;

import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.util.genericHelper;

public class EmployeeFactory {

    public static Employee createEmployee(String firstName, String lastName, EmployeeGender employeeGender, EmployeeRace employeeRace, EmployeeContact employeeContact, Position position) {

        if (genericHelper.isNullOrEmpty(firstName) || genericHelper.isNullOrEmpty(lastName))
            return null;

        String employeeId = genericHelper.generateId();

        Employee employee = new Employee.Builder().setEmployeeId(employeeId).
                                        setFirstName(firstName).
                                        setLastName(lastName).
                                        setEmployeeGender(employeeGender).
                                        setEmployeeRace(employeeRace).
                                        setEmployeeContact(employeeContact).
                                        setPosition(position).
                                        build();

                                        return employee;
    }
}
