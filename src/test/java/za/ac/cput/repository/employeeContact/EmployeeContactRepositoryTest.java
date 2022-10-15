package za.ac.cput.repository.employeeContact;
/* EmployeeContactRepositoryTest.java
 This is a Employee Contact Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: October 2022
  */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.factory.contact.EmployeeContactFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactRepositoryTest {
    private final EmployeeContact employeeContact1 = new EmployeeContact.Builder()
            .setEmployeeID("Luko073")
            .setContactTypeId("Email@")
            .setContact("Vuyisa22@gmail.com")
            .build();

    @Autowired
    private IEmployeeContactRepository employeeContactRepository;
    private static EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact("Vuy200","Email","Vuy@outlook.com");

    @Test
    void create() {
        EmployeeContact created = employeeContactRepository.save(employeeContact);
        assertEquals(employeeContact.getEmployeeId(), created.getEmployeeId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        EmployeeContact read = employeeContactRepository.getById(employeeContact.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        EmployeeContact updated = new EmployeeContact.Builder().copy(employeeContact).setEmployeeID("Vuyi2001").build();
        assertNotNull(employeeContactRepository.save(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        EmployeeContact saved = employeeContactRepository.save(employeeContact1);
        List<EmployeeContact> getAll = employeeContactRepository.findAll();
        employeeContactRepository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(employeeContactRepository.getAll());
    }

}