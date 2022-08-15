package za.ac.cput.service.gender.Impl;

/* GenderServiceTest.java
  This is a Gender Service Test
  Author: Vuyisa Nkangana(218192215)
  Due Date: August 2022
  */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.factory.gender.GenderFactory;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenderServiceImplTest {
    @Autowired
    private GenderServiceImpl genderService;
    private static Gender gender = GenderFactory.createGender("Vuy22", "Nkangana");

    @Test
    void create(){
        Gender created = genderService.create(gender);
        assertEquals(created.getId(), gender.getName());
        System.out.println("created" + created);
    }
    @Test
    @Disabled
    void read(){
        Optional<Gender> read = genderService.read(gender.getId());
        assertNotNull(read);
        System.out.println("read" + read);
    }
    @Test
    @Disabled
    void update(){
        Gender saved = genderService.create(gender);
        Gender updated = new Gender.Builder().copy(gender).setId("002").build();
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    @Disabled
    void delete(){
        this.genderService.delete(gender);
    }
    @Test
    void getAll(){
        System.out.println("Showing All");
        System.out.println(genderService.getAll());
    }

}