/*
CustomerFactoryTest.java
This is customer repository test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.repository.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.factory.role.CustomerFactory;
import za.ac.cput.repository.table.TableRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CustomerRepositoryTest {

    private final Customer customer = new Customer.Builder()
            .setCustomerId("120")
            .setCustomerName("Felecia")
            .build();

    @Autowired
    private CustomerRepository repository;

    @Test
    void save() {
        Customer saved = repository.save(customer);
        assertNotNull(saved);
        assertSame(saved, customer);
    }

    @Test
    void read() {
        Customer saved = repository.save(customer);
        Optional<Customer> read = repository.findById(saved.getCustomerId());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(customer, output)
        );
    }

    @Test
    void delete() {
        Customer saved = repository.save(customer);
        List<Customer> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(customer);
        List <Customer> getAll = repository.findAll();
        assertEquals(1, getAll.size());

    }

}
