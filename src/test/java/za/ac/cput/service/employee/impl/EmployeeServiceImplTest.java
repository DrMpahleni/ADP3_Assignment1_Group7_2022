package za.ac.cput.service.employee.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.Employee;
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
            .build();

    @Autowired private EmployeeService service;

    @Test
    void save() {
        Employee saved = service.save(employee);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(employee, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Employee saved = service.save(employee);
        Optional<Employee> read = service.read(saved.getEmployeeId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(employee, output)
        );
    }

    @Test
    void delete() {
        this.service.delete(employee);
    }

    @Test
    void findByStaffId() {
        Employee saved = service.save(employee);
        String employeeId = saved.getEmployeeId();
        List<Employee> employeeNameList = service.getAll(employeeId);
        System.out.println(employeeNameList);
        assertSame(1, employeeNameList.size());
    }
}