package za.ac.cput.controller.contactType;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.factory.contact.ContactTypeFactory;
import za.ac.cput.factory.contact.EmployeeContactFactory;
import za.ac.cput.service.contactType.IContactTypeService;
import za.ac.cput.service.contactType.Impl.ContactTypeServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("restaurant/contact-type/")
@Slf4j
public class ContactTypeController {
    /* @Autowired
     private ContactTypeServiceImpl contactTypeService;
 */
    private final IContactTypeService contactTypeService;

    @Autowired
    public ContactTypeController(IContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @PostMapping("/create")
   /* public ContactType save(ContactType contactType) {
            ContactType newContactType = ContactTypeFactory.createContactType(contactType.getId(), contactType.getName());
            return contactTypeService.create(contactType);
    }
*/
public ResponseEntity<ContactType>save(@RequestBody ContactType contactType){
    log.info("Save Request: {}",contactType);
        System.out.println(String.format("Save Request: %s", contactType));
    ContactType save = contactTypeService.create(contactType);
            return ResponseEntity.ok(save);
    }
    public Optional<ContactType> getById(@PathVariable String contactTypeId) {
        return this.contactTypeService.read(contactTypeId);
    }
    @GetMapping("/read/{Id}")
    public ResponseEntity<ContactType>read(@PathVariable String contactTypeId){
        ContactType contactType = getById(contactTypeId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(contactType);
    }
    @PostMapping("/update")
    public ContactType update(@RequestBody ContactType contactType) {
        return contactTypeService.update(contactType);
    }

    @DeleteMapping("delete/{contactTypeId}")
    public ResponseEntity<Void> delete(@PathVariable String contactTypeId) {
        log.info("Read request: {}", contactTypeId);
        this.contactTypeService.deleteById(contactTypeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ContactType>>findAll(){
        List<ContactType>contactTypes = this.contactTypeService.findAll();
        return ResponseEntity.ok(contactTypes);
    }
}
