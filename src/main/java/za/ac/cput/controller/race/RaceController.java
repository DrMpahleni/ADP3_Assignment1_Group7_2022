package za.ac.cput.controller.race;

/*RaceController.java
This is race controller class
@Author: Lihle Njobe(218193882)
Due date: 21 August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.race.Race;

import za.ac.cput.service.race.IRaceService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restuarant/race")
@Slf4j

public class RaceController {

    private IRaceService IraceService;

    @Autowired
    public RaceController(IRaceService IraceService) {
        this .IraceService = IraceService;
    }
    @PostMapping("Save")
    public ResponseEntity<Race> save(@Valid @RequestBody Race race) {
        log.info("Save request: {}", race);
        Race save = IraceService.create(race);
        return ResponseEntity.ok(save);
    }

    private Optional<Race> getById(Integer id) {
        return this.IraceService.read(id);
    }

    @GetMapping("/read{id}")
    public ResponseEntity<Race> read(@PathVariable Integer id) {
        log.info("Read request: {} raceId");
        Race race = getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(race);
    }

    @PutMapping("/update")
    public ResponseEntity<Race> update(@Valid @RequestBody Race race) {
        log.info("Update request: {} ", race);
        Race updated = IraceService.update(race);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("delete/{raceId}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        log.info("Delete Request: {} ", id);
        this.IraceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Race>> getAll(Integer id) {
        List<Race> races = this.IraceService.getAll(id);
        return ResponseEntity.ok(races);
    }

}
