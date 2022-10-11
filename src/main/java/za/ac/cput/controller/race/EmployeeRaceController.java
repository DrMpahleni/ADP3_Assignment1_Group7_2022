package za.ac.cput.controller.race;

/* EmployeeRaceController.java
this is EmployeeRace controller class
@Author: Lihle Njobe(218193882)
Due date: 21 August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.service.race.IEmployeeRaceService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("restuarant/employeeRace")
@Slf4j

public class EmployeeRaceController {
    private  IEmployeeRaceService IemployeeRaceService;

    @Autowired
    public EmployeeRaceController(IEmployeeRaceService IemployeeRaceService) {
        this .IemployeeRaceService = IemployeeRaceService;
    }
    @PostMapping("Save")
    public ResponseEntity<EmployeeRace> save(@Valid @RequestBody EmployeeRace employeeRace) {
        log.info("Save request: {}", employeeRace);
        EmployeeRace save = IemployeeRaceService.create(employeeRace);
        return ResponseEntity.ok(save);
    }

    private Optional<EmployeeRace> getById(Integer raceId) {
        return this.IemployeeRaceService.read(raceId);
    }

    @GetMapping("/read{raceId}")
    public ResponseEntity<EmployeeRace> read(@PathVariable Integer raceId) {
        log.info("Read request: {} raceId");
        EmployeeRace employeeRace = getById(raceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(employeeRace);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeRace> update(@Valid @RequestBody EmployeeRace employeeRace) {
        log.info("Update request: {} ", employeeRace);
        EmployeeRace updated = IemployeeRaceService.update(employeeRace);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("delete/{raceId}")
    public ResponseEntity<Void> delete (@PathVariable Integer raceId){
        log.info("Delete Request: {} ", raceId);
        this.IemployeeRaceService.deleteById(raceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeRace>> getAll(Integer raceId) {
        List<EmployeeRace> employeeRaces = this.IemployeeRaceService.getAll(raceId);
        return ResponseEntity.ok(employeeRaces);
    }

}
