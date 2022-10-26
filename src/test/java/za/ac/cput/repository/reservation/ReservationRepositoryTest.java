/*
ReservationRepositoryTest.java
Author: Felecia Zweni (218330189)
Date: August 2022

 */


package za.ac.cput.repository.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.factory.restaurant.ReservationFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ReservationRepositoryTest {

    private final Reservation reservation = new Reservation.Builder()
            .setDate("01 December 2022")
            .setName("Lihle")
            .setAmount(200)
            .build();

    @Autowired
    private ReservationRepository repository;

    @Test
    void save() {
        Reservation saved = repository.save(reservation);
        assertNotNull(saved);
        assertSame(saved, reservation);
    }

    @Test
    void read() {
        Reservation saved = repository.save(reservation);
        Optional<Reservation> read = repository.findById(saved.getName());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(reservation, output));
    }

    @Test
    void delete() {
        Reservation saved = repository.save(reservation);
        List<Reservation> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(reservation);
        List <Reservation> getAll = repository.findAll();
        assertEquals(1, getAll.size());
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }


}
