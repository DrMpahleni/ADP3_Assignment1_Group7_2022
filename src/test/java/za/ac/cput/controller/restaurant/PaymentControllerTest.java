package za.ac.cput.controller.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.service.restaurant.PaymentService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @LocalServerPort private int port;
    @Autowired private TestRestTemplate restTemplate;
    @Autowired private PaymentController controller;
    @Autowired private PaymentService service;

    private Payment payment;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        payment = new Payment.Builder()
                .setPaymentId("001")
                .setOrderId("101")
                .setCustomerId("004")
                .setPaymentType("Card")
                .setAmount(200)
                .build();
        this.baseUrl = "http://localhost:" + this.port + "restaurant/payment/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate
                .postForEntity(url, this.payment, Payment.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.payment.getPaymentId();
        System.out.println(url);
        ResponseEntity<Payment> response = this.restTemplate.getForEntity(url, Payment.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.payment.getPaymentId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Payment[]> response =
                this.restTemplate.getForEntity(url, Payment[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}