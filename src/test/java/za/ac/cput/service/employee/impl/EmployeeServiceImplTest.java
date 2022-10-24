package za.ac.cput.service.employee.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {

    private final Employee employee = new Employee.Builder()
            .setEmployeeId("001")
            .setLastName("John")
            .setLastName("Doe")
            .setEmployeeGender("Male")
            .setEmployeeRace("Coloured")
            .setEmployeePosition("Waiter")
            .setEmployeeContact("0215556884")
            .setEmployeeEmail("john@gmail.com")
            .build();

    @Autowired private EmployeeService service;

    @Test
    void create() {
        Employee saved = service.create(employee);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(employee, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Employee saved = service.create(employee);
        Optional<Employee> read = service.read(saved.getEmployeeId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(employee, output)
        );
    }

    @Test
    void update () {
        Employee saved = service.create(employee);
        Employee updated = new Employee.Builder().copy(employee).setEmployeeId("002").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        this.service.delete(employee);
    }

    @Test
    void findByStaffId() {
        Employee saved = service.create(employee);
        String employeeId = saved.getEmployeeId();
        List<Employee> employeeNameList = service.getAll(employeeId);
        System.out.println(employeeNameList);
        assertSame(1, employeeNameList.size());
    }
}