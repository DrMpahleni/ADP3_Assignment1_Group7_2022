/*
ReceptionistController.java
This is receptionist controller class.
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
import za.ac.cput.domain.role.Receptionist;
import za.ac.cput.service.role.ReceptionistService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("role/receptionist")
@Slf4j

public class ReceptionistController {

    private final ReceptionistService receptionistService;

    @Autowired
    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    @PostMapping("save")
    public ResponseEntity<Receptionist> save(@Valid @RequestBody Receptionist receptionist) {
        log.info("Save request: {}", receptionist);
        Receptionist save = receptionistService.save(receptionist);
        return ResponseEntity.ok(save);
    }

    private Optional<Receptionist> getById(String receptionId) {
        return this.receptionistService.read(receptionId);
    }

    @GetMapping("read/{receptionId}")
    public ResponseEntity<Receptionist> read(@PathVariable String receptionId) {
        log.info("Read request: {}", receptionId);
        Receptionist receptionist = getById(receptionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(receptionist);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String receptionId) {
        log.info("Read request: {}", receptionId);
        this.receptionistService.deleteById(receptionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Receptionist>> getAll(String receptionistId) {
        List<Receptionist> receptionists = this.receptionistService.getAll(receptionistId);
        return ResponseEntity.ok(receptionists);
    }
}