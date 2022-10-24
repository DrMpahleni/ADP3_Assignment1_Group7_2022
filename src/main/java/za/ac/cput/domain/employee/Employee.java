/*
    Employee.java
    entity for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.domain.employee;

import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.domain.race.EmployeeRace;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String employeeGender;
    private String employeeRace;
    private String employeePosition;
    private String employeeContact;
    private String employeeEmail;

    public Employee() {
    }

    private Employee (Builder builder) {

        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.employeeGender = builder.employeeGender;
        this.employeeRace = builder.employeeRace;
        this.employeePosition = builder.employeePosition;
        this.employeeContact = builder.employeeContact;
        this.employeeEmail = builder.employeeEmail;
    }

    public String getEmployeeId() {

        return employeeId;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public String getEmployeeRace() {
        return employeeRace;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeRace='" + employeeRace + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", employeeContact='" + employeeContact + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }

    public static class Builder {

        private String employeeId, firstName, lastName, employeeGender, employeeRace, employeePosition, employeeContact, employeeEmail;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;

            return this;
        }

        public Builder setEmployeeGender(String employeeGender) {
            this.employeeGender = employeeGender;

            return this;
        }

        public Builder setEmployeeRace(String employeeRace) {
            this.employeeRace = employeeRace;

            return this;
        }

        public Builder setEmployeePosition(String employeePosition) {
            this.employeePosition = employeePosition;

            return this;
        }

        public Builder setEmployeeContact(String employeeContact) {
            this.employeeContact = employeeContact;
            return this;

        }

        public Builder setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;

            return this;
        }

        public Employee build () {

            return new Employee(this);
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.employeeGender = employee.employeeGender;
            this.employeeRace = employee.employeeRace;
            this.employeePosition = employee.employeePosition;
            this.employeeContact = employee.employeeContact;
            this.employeeEmail = employee.employeeEmail;

            return this;
        }
    }
}
