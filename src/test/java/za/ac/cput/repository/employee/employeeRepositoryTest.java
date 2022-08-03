/*
    employeeRepositoryTest.java
    Repository test for employee
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

class employeeRepositoryTest {

    private static employeeRepository repository = employeeRepository.getRepository();
    private static Employee employee = EmployeeFactory.createEmployee("Bob", "John");

    @Test
    void create() {
        Employee created = repository.create(employee);
        assertEquals(employee.getEmployeeId(),created.getEmployeeId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Employee read = repository.read(employee.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Employee updated = new Employee.Builder().copy(employee).setFirstName("Mike").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(employee.getEmployeeId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }


}