package za.ac.cput.controller.race;

/* EmployeeRaceController.java
this is EmployeeRace controller class
@Author: Lihle Njobe(218193882)
Due date: 21 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.factory.race.EmployeeRaceFactory;
import za.ac.cput.service.race.impl.EmployeeRaceServiceImpl;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping

public class EmployeeRaceController {
    @Autowired
    private EmployeeRaceServiceImpl employeeRaceServiceImpl;

    @PostMapping("/create")
     public EmployeeRace create(@RequestBody EmployeeRace employeeRace) {
        EmployeeRace newEmployeeRace = EmployeeRaceFactory.createEmployeeRace(employeeRace.getRaceName());

        return employeeRaceServiceImpl.create(newEmployeeRace);
    }
    @GetMapping("/read{id}")
    public Optional<EmployeeRace> read(@PathVariable Integer raceId ) {
        return employeeRaceServiceImpl.read(raceId);
    }

    @PostMapping("/update")
    public EmployeeRace update(@RequestBody EmployeeRace employeeRace) {
        return employeeRaceServiceImpl.update(employeeRace);
    }
    @DeleteMapping("delete/{raceId}")
    public void delete(@PathVariable String employeeRace){
        return;
    }

    @GetMapping("/getAll")
    public Set<EmployeeRace> getAll() {
        return employeeRaceServiceImpl.getAll();
    }

}
