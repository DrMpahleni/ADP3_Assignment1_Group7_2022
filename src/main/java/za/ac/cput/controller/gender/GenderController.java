package za.ac.cput.controller.gender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.factory.gender.GenderFactory;
import za.ac.cput.service.gender.Impl.GenderServiceImpl;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("restaurant/gender/")
@Slf4j

public class GenderController {
    @Autowired
    private GenderServiceImpl genderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Gender create(@RequestBody Gender gender){
        Gender newGender = GenderFactory.createGender(gender.getId(), gender.getName());
        return genderService.create(gender);
    }

    @RequestMapping("/read/{Id}")
    public Optional<Gender> read(@PathVariable String employeeId){
        return genderService.read(employeeId);
    }

    @PostMapping("/update")
    public Gender update(@RequestBody Gender gender){
        return genderService.update(gender);
    }


    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) {
        log.info("Read request: {}", employeeId);
        this.genderService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public Set<Gender> getEmployeeGender(){
        return genderService.getAll();
    }
}
