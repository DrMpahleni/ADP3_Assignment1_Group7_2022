package za.ac.cput.repository.employeeGender;

/* EmployeeGenderRepositoryTest.java
 This is a Employee Gender Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: October 2022
  */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.factory.gender.EmployeeGenderFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeGenderRepositoryTest {
    private final EmployeeGender employeeGender1 = new EmployeeGender.Builder()
            .setEmployeeId("Olw552")
            .setGenderId("Fem083")
            .build();

    @Autowired
    private IEmployeeGenderRepository employeeGenderRepository;
    private static EmployeeGender employeeGender = EmployeeGenderFactory.createEmployeeGender("Siv073", "Male22");


    @Test
    void create() {
        EmployeeGender created = employeeGenderRepository.save(employeeGender);
        assertEquals(employeeGender.getEmployeeId(), created.getEmployeeId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        EmployeeGender read = employeeGenderRepository.getById(employeeGender.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        EmployeeGender updated = new EmployeeGender.Builder().copy(employeeGender).setEmployeeId("TKoo3331").build();
        assertNotNull(employeeGenderRepository.save(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        EmployeeGender saved = employeeGenderRepository.save(employeeGender1);
        List<EmployeeGender> getAll = employeeGenderRepository.findAll();
        employeeGenderRepository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(employeeGenderRepository.getAll());
    }

}