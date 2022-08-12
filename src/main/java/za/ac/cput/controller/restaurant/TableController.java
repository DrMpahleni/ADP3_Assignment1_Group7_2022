package za.ac.cput.controller.restaurant;

/*
TableController.java
This is table controller class.
Author: Felecia Zweni (218330189)
Date: 07 August 2022

 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.service.restaurant.TableService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/table")
@Slf4j
public class TableController {


    private final TableService tableService;

    @Autowired
    public TableController (TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("save")
    public ResponseEntity<Table> save (@Valid @RequestBody Table table) {
        log.info("Save request: {}", table);
        Table save = tableService.save(table);
        return ResponseEntity.ok(save);
    }

    private Optional<Table> getById(String tblNum) {
        return this.tableService.read(tblNum);
    }

    @GetMapping("read/{tblNum}")
    public ResponseEntity<Table > read (@PathVariable String tblNum) {
        log.info("Read request: {}", tblNum);
        Table table = getById(tblNum)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(table);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable int tblNum) {
        log.info("Read request: {}", tblNum);
        this.tableService.deleteById(tblNum);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Table>> getAll(int tblNum) {
        List<Table> tables = this.tableService.getAll(tblNum);
        return ResponseEntity.ok(tables);
    }
}
