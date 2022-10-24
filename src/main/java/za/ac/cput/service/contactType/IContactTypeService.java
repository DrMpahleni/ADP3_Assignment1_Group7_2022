package za.ac.cput.service.contactType;

import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;

public interface IContactTypeService extends IService<ContactType, String> {
    List<ContactType> findAll();

    void deleteById(String id);

}
