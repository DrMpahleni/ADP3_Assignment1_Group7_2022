package za.ac.cput.repository.gender;

/* GenderRepositoryTest.java
 This is a Gender Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Gender;
import za.ac.cput.factory.GenderFactory;

import static org.junit.jupiter.api.Assertions.*;

class GenderRepositoryTest {
    private static GenderRepository repository = GenderRepository.getRepository();
    private static Gender gender = GenderFactory.createGender("Hosp2213", "Lutho");

    @Test
    void create() {
        Gender created = repository.create(gender);
        assertEquals(gender.getId(), created.getId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Gender read = repository.read(gender.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Gender updated = new Gender.Builder().copy(gender).setName("Olona").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(gender.getId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }
}