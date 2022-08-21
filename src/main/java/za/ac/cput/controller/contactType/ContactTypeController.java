package za.ac.cput.controller.contactType;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;
import za.ac.cput.service.contactType.Impl.ContactTypeServiceImpl;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("restaurant/contactType/")
@Slf4j
public class ContactTypeController {
    @Autowired
    private ContactTypeServiceImpl contactTypeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ContactType create(@RequestBody ContactType contactType) {
        ContactType newContactType = ContactTypeFactory.createContactType(contactType.getId(), contactType.getName());
        return contactTypeService.create(contactType);
    }

    @RequestMapping("/read/{Id}")
    public Optional<ContactType> read(@PathVariable String employeeId) {
        return contactTypeService.read(employeeId);
    }
    @PostMapping("/update")
    public ContactType update(@RequestBody ContactType contactType) {
        return contactTypeService.update(contactType);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String employeeId) {
        log.info("Read request: {}", employeeId);
        this.contactTypeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/getAll")
    public Set<ContactType> getContactType() {
        return contactTypeService.getAll();
    }
}
