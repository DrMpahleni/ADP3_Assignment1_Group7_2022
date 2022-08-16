package za.ac.cput.service.employeeGender.Impl;

/* EmployeeGenderServiceTest.java
  This is a Employee Gender Service Test
  Author: Vuyisa Nkangana(218192215)
  Due Date: August 2022
  */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.factory.gender.EmployeeGenderFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeGenderServiceImplTest {
    @Autowired
    private EmployeeGenderServiceImpl employeeGenderService;
    private static EmployeeGender employeeGender = EmployeeGenderFactory.createEmployeeGender("Siv002", "Male225");

    @Test
    void create(){
        EmployeeGender created = employeeGenderService.create(employeeGender);
        assertEquals(created.getEmployeeId(), employeeGender.getEmployeeId());
        System.out.println("created" + created);
    }
    @Test
    @Disabled
    void read(){
        Optional<EmployeeGender> read = employeeGenderService.read(employeeGender.getEmployeeId());
        assertNotNull(read);
        System.out.println("read" + read);
    }
    @Test
    @Disabled
    void update(){
        EmployeeGender saved = employeeGenderService.create(employeeGender);
        EmployeeGender updated = new EmployeeGender.Builder().copy(employeeGender).setEmployeeId("002").build();
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    @Disabled
    void delete(){
        this.employeeGenderService.delete(employeeGender);
    }
    @Test
    void getAll(){
        System.out.println("Showing All");
        System.out.println(employeeGenderService.getAll());
    }

}