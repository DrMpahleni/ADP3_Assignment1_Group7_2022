package za.ac.cput.controller.contactType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;
import za.ac.cput.service.contactType.Impl.ContactTypeServiceImpl;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactTypeControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private ContactTypeController controller;
    @Autowired private ContactTypeServiceImpl service;

    private ContactType contactType;
    private String baseUrl;

    @BeforeEach
    void setUp() {
       assertNotNull(controller);
       this.contactType = ContactTypeFactory
               .createContactType("test-id", "test-name");
        this.baseUrl = "http:localhost:" + this.port + "restaurant/contactType/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<ContactType> response = this.restTemplate
                .postForEntity(url, this.contactType, ContactType.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.contactType.getId();
        System.out.println(url);
        ResponseEntity<ContactType> response = this.restTemplate.getForEntity(url, ContactType.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.contactType.getId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<ContactType[]> response =
                this.restTemplate.getForEntity(url, ContactType[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }


}