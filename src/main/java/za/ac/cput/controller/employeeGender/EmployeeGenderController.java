package za.ac.cput.controller.employeeGender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.factory.gender.EmployeeGenderFactory;
import za.ac.cput.service.employeeGender.Impl.EmployeeGenderServiceImpl;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("restaurant/employeeGender/")
@Slf4j

public class EmployeeGenderController {
    @Autowired
    private EmployeeGenderServiceImpl employeeGenderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EmployeeGender create(@RequestBody EmployeeGender employeeGender){
        EmployeeGender newEmployeeGender = EmployeeGenderFactory.createEmployeeGender(employeeGender.getEmployeeId(), employeeGender.getGenderId());
        return employeeGenderService.create(employeeGender);
    }

    @RequestMapping("/read/{Id}")
    public Optional<EmployeeGender> read(@PathVariable String employeeId){
        return employeeGenderService.read(employeeId);
    }

    @PostMapping("/update")
    public EmployeeGender update(@RequestBody EmployeeGender employeeGender){
        return employeeGenderService.update(employeeGender);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) {
        log.info("Read request: {}", employeeId);
        this.employeeGenderService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public Set<EmployeeGender> getEmployeeGender(){
        return employeeGenderService.getAll();
    }


}
