/*
tableRepositoryTest.java
author: Felecia Zweni
Date: August 2022
 */

package za.ac.cput.repository.table;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.restaurant.Table;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class tableRepositoryTest {

    private final Table table = new Table.Builder()
            .setTblNum("001")
            .setSeatAmount(2)
            .build();

    @Autowired
    private TableRepository repository;

    @Test
    void save() {
        Table saved = repository.save(table);
        assertNotNull(saved);
        assertSame(saved, table);
    }

    @Test
    void read() {
        Table saved = repository.save(table);
       Optional<Table> read = repository.findById(saved.getTblNum());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(table, output)
        );
    }

    @Test
    void delete() {
        Table saved = repository.save(table);
        List<Table> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(table);
        List <Table> getAll = repository.findAll();
        assertEquals(1, getAll.size());
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}
