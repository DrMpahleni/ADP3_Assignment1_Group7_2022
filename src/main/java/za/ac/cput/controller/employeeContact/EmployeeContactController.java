package za.ac.cput.controller.employeeContact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.factory.contact.EmployeeContactFactory;
import za.ac.cput.service.employeeContact.Impl.EmployeeContactServiceImpl;

import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("restaurant/employeeContact/")
@Slf4j

public class EmployeeContactController {
    @Autowired
    private EmployeeContactServiceImpl employeeContactService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EmployeeContact create(@RequestBody EmployeeContact employeeContact) {
        EmployeeContact newEmployeeContact = EmployeeContactFactory.createEmployeeContact(employeeContact.getContact(), employeeContact.getEmployeeId(), employeeContact.getContactTypeId());
        return employeeContactService.create(employeeContact);
    }

    @RequestMapping("/read/{Id}")
    public Optional<EmployeeContact> read(@PathVariable String employeeId) {
        return employeeContactService.read(employeeId);
    }
    @PostMapping("/update")
    public EmployeeContact update(@RequestBody EmployeeContact employeeContact) {
        return employeeContactService.update(employeeContact);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) {
        log.info("Read request: {}", employeeId);
        this.employeeContactService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public Set<EmployeeContact> getContactType() {
        return employeeContactService.getAll();
    }
}
