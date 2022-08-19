/*
CustomerController.java
This is customer controller class.
Author: Felecia Zweni(218330189)
Date: August 2022
 */

package za.ac.cput.controller.role;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.role.Customer;
import za.ac.cput.service.role.CustomerService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("role/customer")
@Slf4j

public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("save")
    public ResponseEntity<Customer> save (@Valid @RequestBody Customer customer) {
        log.info("Save request: {}", customer);
        Customer save = customerService.save(customer);
        return ResponseEntity.ok(save);
    }

    private Optional<Customer> getById(String customerName) {
        return this.customerService.read(customerName);
    }

    @GetMapping("read/{customerName}")
    public ResponseEntity<Customer > read (@PathVariable String customerName) {
        log.info("Read request: {}", customerName);
        Customer customer = getById(customerName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String customerName) {
        log.info("Read request: {}", customerName);
        this.customerService.deleteById(customerName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAll(String customerName) {
        List<Customer> customers = this.customerService.getAll(customerName);
        return ResponseEntity.ok(customers
        );
}
}