/*
ReceptionistServiceTest.java
This is receptionist service test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */


package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.service.role.ReceptionistService;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReceptionistServiceTest {

    private final Receptionist receptionist = new Receptionist.Builder()
            .setReceptionId("1234")
            .setPositionId(67)
            .build();

    @Autowired
    private ReceptionistService service;

    @Test
    void save() {
        Receptionist saved = service.create(receptionist);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(receptionist, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Receptionist saved = service.create(receptionist);
        Optional<Receptionist> read = service.read(saved.getReceptionId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(receptionist, output)
        );
    }

    @Test
    void update() {
        Receptionist saved = service.create(receptionist);
        Receptionist updated = new Receptionist.Builder().copy(receptionist).setReceptionId("1235").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        this.service.delete(receptionist);
    }




}
