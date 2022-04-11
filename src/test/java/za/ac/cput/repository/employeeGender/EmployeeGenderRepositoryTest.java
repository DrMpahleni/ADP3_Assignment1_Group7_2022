package za.ac.cput.repository.employeeGender;

/* EmployeeGenderRepositoryTest.java
 This is a Employee Gender Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeGender;
import za.ac.cput.factory.EmployeeGenderFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeGenderRepositoryTest {
    private static EmployeeGenderRepository repository = EmployeeGenderRepository.getRepository();
    private static EmployeeGender employeeGender = EmployeeGenderFactory.createEmployeeGender("Toko1985", "Fem001");

    @Test
    void create() {
        EmployeeGender created = repository.create(employeeGender);
        assertEquals(employeeGender.getEmployeeId(), created.getEmployeeId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        EmployeeGender read = repository.read(employeeGender.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        EmployeeGender updated = new EmployeeGender.Builder().copy(employeeGender).setEmployeeId("TKoo3331").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(employeeGender.getEmployeeId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}