package za.ac.cput.controller.race;

/*RaceController.java
This is race controller class
@Author: Lihle Njobe(218193882)
Due date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.race.Race;
import za.ac.cput.factory.race.RaceFactory;
import za.ac.cput.service.race.RaceService;

import java.util.Optional;
import java.util.Set;

public class RaceController {

    @Autowired
    private RaceService raceService;

    @PostMapping("/create")
    public Race create(@RequestBody Race race) {
        Race newRace = RaceFactory.createRace(race.getName());

        return raceService.create(newRace);
    }
    @GetMapping("/read{id}")
    public Optional<Race> read(@PathVariable Integer id ) {
        return raceService.read(id);
    }

    @PostMapping("/update")
    public Race update(@RequestBody Race race) {
        return raceService.update(race);
    }
    @DeleteMapping("delete/{raceId}")
    public void delete(@PathVariable String race){
        return;
    }

    @GetMapping("/getAll")
    public Set<Race> getAll() {
        return raceService.getAll();
    }

}

