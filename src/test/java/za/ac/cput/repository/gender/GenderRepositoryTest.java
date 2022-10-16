package za.ac.cput.repository.gender;

/* GenderRepositoryTest.java
 This is a Gender Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: October 2022
  */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.factory.gender.GenderFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GenderRepositoryTest {

    private final Gender gender1 = new Gender.Builder()
            .setName("Male")
            .setId("Male088")
            .build();

    @Autowired
    private IGenderRepository genderRepository;
    private static Gender gender = GenderFactory.createGender("Mal088", "Male");
    @Test
    void create() {
        Gender created = genderRepository.save(gender);
        assertEquals(gender.getId(), created.getId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Gender read = genderRepository.getById(gender.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Gender updated = new Gender.Builder().copy(gender).setName("Olona").build();
        assertNotNull(genderRepository.save(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        Gender saved = genderRepository.save(gender1);
        List<Gender> getAll = genderRepository.findAll();
        genderRepository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(genderRepository.getAll());
    }
}