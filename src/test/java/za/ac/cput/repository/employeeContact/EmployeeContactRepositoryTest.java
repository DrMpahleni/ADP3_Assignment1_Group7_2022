package za.ac.cput.repository.employeeContact;
/* EmployeeContactRepositoryTest.java
 This is a Employee Contact Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.factory.contact.EmployeeContactFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactRepositoryTest {
    private static EmployeeContactRepository repository = EmployeeContactRepository.getRepository();
    private static EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(2181922, 66087, "ntand@gmail.com");

    @Test
    void create() {
        EmployeeContact created = repository.create(employeeContact);
        assertEquals(employeeContact.getEmployeeId(), created.getEmployeeId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        EmployeeContact read = repository.read(employeeContact.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        EmployeeContact updated = new EmployeeContact.Builder().copy(employeeContact).setEmployeeID("Vuyi2001").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(employeeContact.getEmployeeId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}