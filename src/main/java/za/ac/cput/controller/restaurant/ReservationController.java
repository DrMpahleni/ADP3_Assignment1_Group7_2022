package za.ac.cput.controller.restaurant;/*
ReservationController.java
This is reservation controller class.
Author: Felecia Zweni (218330189)
Date: 07 August 2022

 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.service.restaurant.ReservationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restuarant/reservation")
@Slf4j

public class ReservationController {



        private final ReservationService reservationService;

        @Autowired
        public ReservationController (ReservationService reservationService) {
            this.reservationService = reservationService;
        }

        @PostMapping("save")
        public ResponseEntity<Reservation> save (@Valid @RequestBody Reservation reservation) {
            log.info("Save request: {}", reservation);
            Reservation save = reservationService.save(reservation);
            return ResponseEntity.ok(save);
        }

        private Optional<Reservation> getById(String name) {
            return this.reservationService.read(name);
        }

        @GetMapping("read/{name}")
        public ResponseEntity<Reservation> read (@PathVariable String name) {
            log.info("Read request: {}", name);
            Reservation reservation = getById(name)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return ResponseEntity.ok(reservation);
        }

        @DeleteMapping("delete")
        public ResponseEntity<Void> delete(@PathVariable String name) {
            log.info("Read request: {}", name);
            this.reservationService.deleteById(name);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("all")
        public ResponseEntity<List<Reservation>> getAll(String name) {
            List<Reservation> reservations = this.reservationService.getAll(name);
            return ResponseEntity.ok(reservations);
        }
}
