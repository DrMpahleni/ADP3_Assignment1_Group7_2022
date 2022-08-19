/*
    PaymentController.java
    Controller for Payment
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.controller.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.restaurant.Payment;
import za.ac.cput.service.restaurant.PaymentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/payment/")
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired public PaymentController (PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("save")
    public ResponseEntity<Payment> save (@Valid @RequestBody Payment payment) {
        log.info("Save request: {}", payment);
        Payment save = paymentService.create(payment);
        return ResponseEntity.ok(save);
    }

    private Optional<Payment> getById(String paymentId) {
        return this.paymentService.read(paymentId);
    }

    @GetMapping("read/{paymentId}")
    public ResponseEntity<Payment> read (@PathVariable String paymentId) {
        log.info("Read request: {}", paymentId);
        Payment employee = getById(paymentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("update")
    public ResponseEntity<Payment> update (@Valid @RequestBody Payment payment) {
        log.info("Update request: {}", payment);
        Payment updated = paymentService.update(payment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String paymentId) {
        log.info("Read request: {}", paymentId);
        this.paymentService.deleteById(paymentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Payment>> getAll(String paymentId) {
        List<Payment> employees = this.paymentService.getAll(paymentId);
        return ResponseEntity.ok(employees);
    }
}
