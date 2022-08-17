/*
CustomerControllerTest.java
This is customer controller test class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.role.CustomerController;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.service.role.CustomerService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CustomerControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private CustomerController controller;
    @Autowired private CustomerService service;

    private Customer customer;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        customer  = new Customer.Builder()
                .setCustomerId("1333")
                .setCustomerName("William")
                .build();
        this.baseUrl = "http://localhost:" + this.port + "role/customer";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate
                .postForEntity(url, this.customer, Customer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.customer.getCustomerName();
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate.getForEntity(url, Customer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.customer.getCustomerName();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Customer[]> response =
                this.restTemplate.getForEntity(url, Customer[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}

