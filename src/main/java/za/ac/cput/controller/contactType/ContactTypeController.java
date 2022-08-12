package za.ac.cput.controller.contactType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;
import za.ac.cput.service.contactType.Impl.ContactTypeServiceImpl;

import java.util.Optional;
import java.util.Set;

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

    @DeleteMapping("/delete/Id")
    public boolean delete(@PathVariable String employeeId) {
        return contactTypeService.delete(employeeId);
    }

    @GetMapping("/getAll")
    public Set<ContactType> getContactType() {
        return contactTypeService.getAll();
    }
}
