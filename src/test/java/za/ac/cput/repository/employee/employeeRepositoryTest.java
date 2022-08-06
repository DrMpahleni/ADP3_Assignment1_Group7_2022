/*
    employeeRepositoryTest.java
    Repository test for employee
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.factory.employee.EmployeeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class employeeRepositoryTest {

    private final Employee employee1 = new Employee.Builder()
            .setEmployeeId("001")
            .setFirstName("John")
            .setLastName("Doe")
            .build();

    @Autowired private EmployeeRepository repository;
    private static Employee employee = EmployeeFactory.createEmployee("Bob", "John");

    @Test
    void save() {
        Employee saved = repository.save(employee1);
        String output = String.valueOf(saved);
        assertNotNull(saved);
        assertSame(saved, output);
    }

    @Test
    void read() {
        Employee saved = repository.save(employee1);
        Optional<Employee> read = repository.findById(saved.getEmployeeId());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, output)
        );
    }

    @Test
    void delete() {
        Employee saved = repository.save(employee1);
        List<Employee> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(employee1);
        List<Employee> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }


}