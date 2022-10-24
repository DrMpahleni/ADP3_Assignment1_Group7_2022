/*
    employeeRepositoryTest.java
    Repository test for employee
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.repository.IRepository;
import za.ac.cput.repository.employee.EmployeeRepository;
import za.ac.cput.factory.employee.EmployeeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class employeeRepositoryTest {

    private final Employee employee1 = new Employee.Builder()
            .setEmployeeId("001")
            .setFirstName("John")
            .setLastName("Doe")
            .setEmployeeGender("Male")
            .setEmployeeRace("Coloured")
            .setEmployeePosition("Waiter")
            .setEmployeeContact("0215556884")
            .setEmployeeEmail("john@gmail.com")
            .build();
    //private final Employee employee2 = EmployeeFactory.createEmployee("John", "Doe", gender1, race1, contact1, position1);

    @Autowired private EmployeeRepository repository;
    //private static Employee employee = EmployeeFactory.createEmployee("Bob", "John");

    @Test
    void save() {
        Employee saved = this.repository.save(this.employee1);
        String output = String.valueOf(saved);
        assertEquals(saved, this.employee1);
        /*
        assertNotNull(saved);
        System.out.println(saved);
        assertSame(saved, output);
         */
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