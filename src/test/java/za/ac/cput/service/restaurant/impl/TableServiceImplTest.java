/*
TableServiceImplTest.java
Author: Felecia Zweni (218330189)
Date: August 2022
 */

package za.ac.cput.service.restaurant.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.service.restaurant.TableService;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class TableServiceImplTest {

    private final Table table = new Table.Builder()
            .setTblNum("45")
            .setSeatAmount(4)
            .build();

    @Autowired
    private TableService service;

    @Test
    void save() {
        Table saved = service.create(table);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(table, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Table saved = service.create(table);
        Optional<Table> read = service.read(saved.getTblNum());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(table, output)
        );
    }

    @Test
    void update() {
        Table saved = service.create(table);
        Table updated = new Table.Builder().copy(table).setTblNum("43").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        this.service.delete(table);
    }



}
