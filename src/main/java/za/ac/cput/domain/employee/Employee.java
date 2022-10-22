/*
    Employee.java
    entity for Employee
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.domain.employee;

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
    @ManyToOne(targetEntity = EmployeeGender.class, cascade = CascadeType.ALL)
    private EmployeeGender employeeGender;
    @ManyToOne(targetEntity = EmployeeRace.class, cascade = CascadeType.ALL)
    private EmployeeRace employeeRace;

    public Employee() {
    }

    private Employee (Builder builder) {

        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.employeeGender = builder.employeeGender;
        this.employeeRace = builder.employeeRace;
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

    public EmployeeGender getEmployeeGender() {

        return employeeGender;
    }

    public EmployeeRace getEmployeeRace () {

        return employeeRace;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeRace='" + employeeRace + '\'' +
                '}';
    }

    public static class Builder {

        private String employeeId, firstName, lastName;
        private EmployeeGender employeeGender;
        private EmployeeRace employeeRace;

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

        public Builder setEmployeeGender(EmployeeGender employeeGender) {
            this.employeeGender = employeeGender;

            return this;
        }

        public Builder setEmployeeRace (EmployeeRace employeeRace) {
            this.employeeRace = employeeRace;

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

            return this;
        }
    }
}
