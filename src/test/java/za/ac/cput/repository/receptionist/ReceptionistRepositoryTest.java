/*
ReceptionistRepositoryTest.java
This is receptionist repository test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.receptionist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.role.Receptionist;

import za.ac.cput.factory.role.ReceptionistFactory;
import za.ac.cput.repository.table.TableRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ReceptionistRepositoryTest {

    private final Receptionist receptionist = new Receptionist.Builder()
            .setReceptionId("001")
            .setPositionId(2)
            .build();

    @Autowired
    private ReceptionistRepository repository;

    @Test
    void save() {
        Receptionist saved = repository.save(receptionist);
        assertNotNull(saved);
        assertSame(saved, receptionist);
    }

    @Test
    void read() {
        Receptionist saved = repository.save(receptionist);
        Optional<Receptionist> read = repository.findById(saved.getReceptionId());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(receptionist, output)
        );
    }

    @Test
    void delete() {
        Receptionist saved = repository.save(receptionist);
        List<Receptionist> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(receptionist);
        List <Receptionist> getAll = repository.findAll();
        assertEquals(1, getAll.size());

    }

}
