package za.ac.cput.service.contactType;

import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IContactTypeService extends IService<ContactType, String> {
    Set<ContactType> getAll();

}
