package za.ac.cput.repository.contactType;

import za.ac.cput.entity.ContactType;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IContactTypeRepository extends IRepository<ContactType, String> {
    public Set<ContactType> getAll();
}
