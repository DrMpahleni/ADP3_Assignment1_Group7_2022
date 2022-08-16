package za.ac.cput.service.employeeContact.Impl;

/* EmployeeContactServiceTest.java
  This is a Employee Contact Service Test
  Author: Vuyisa Nkangana(218192215)
  Due Date: August 2022
  */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.factory.contact.EmployeeContactFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactServiceImplTest {
    @Autowired
    private EmployeeContactServiceImpl employeeContactService;
    private static EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(222570, "email2214", "email");

    @Test
    void create() {
        EmployeeContact created = employeeContactService.create(employeeContact);
        assertEquals(created.getEmployeeId(), employeeContact.getEmployeeId(), employeeContact.getContactTypeId());
        System.out.println("created" + created);
    }

    @Test
    @Disabled
    void read() {
        Optional<EmployeeContact> read = employeeContactService.read(employeeContact.getEmployeeId());
        assertNotNull(read);
        System.out.println("read" + read);
    }


    @Test
    @Disabled
    void update(){
        EmployeeContact saved = employeeContactService.create(employeeContact);
        EmployeeContact updated = new EmployeeContact.Builder().copy(employeeContact).setEmployeeID("Vuy2201").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void delete(){
            this.employeeContactService.delete(employeeContact);
        }

    @Test
    void getAll(){
        System.out.println("Showing All");
        System.out.println(employeeContactService.getAll());
    }
}