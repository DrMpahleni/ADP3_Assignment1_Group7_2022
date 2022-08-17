/*
CustomerServiceTest.java
This is customer service test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */


package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.service.role.CustomerService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class CustomerServiceTest {
    private final Customer customer = new Customer.Builder()
            .setCustomerId("1444")
            .setCustomerName("Felecia")
            .build();

    @Autowired
    private CustomerService service;

    @Test
    void save() {
        Customer saved = service.create(customer);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(customer, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Customer saved = service.create(customer);
        Optional<Customer> read = service.read(saved.getCustomerId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(customer, output)
        );
    }

    @Test
    void update() {
        Customer saved = service.create(customer);
        Customer updated = new Customer.Builder().copy(customer).setCustomerId("1443").build();
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        this.service.delete(customer);
    }



}
