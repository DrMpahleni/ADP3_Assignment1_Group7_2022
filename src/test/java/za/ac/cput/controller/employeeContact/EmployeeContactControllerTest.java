package za.ac.cput.controller.employeeContact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.service.employeeContact.Impl.EmployeeContactServiceImpl;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeContactControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private EmployeeContactController controller;
    @Autowired private EmployeeContactServiceImpl service;

    private EmployeeContact employeeContact;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        employeeContact = new EmployeeContact.Builder()
                .setContact("Vuyi")
                .setContactTypeId("P_Email023")
                .setEmployeeID("Vuyi2022")
                .build();


        this.baseUrl = "http:localhost:" + this.port + "restaurant/contactType/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<EmployeeContact> response = this.restTemplate
                .postForEntity(url, this.employeeContact, EmployeeContact.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.employeeContact.getEmployeeId();
        System.out.println(url);
        ResponseEntity<EmployeeContact> response = this.restTemplate.getForEntity(url, EmployeeContact.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employeeContact.getEmployeeId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<EmployeeContact[]> response =
                this.restTemplate.getForEntity(url, EmployeeContact[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


}