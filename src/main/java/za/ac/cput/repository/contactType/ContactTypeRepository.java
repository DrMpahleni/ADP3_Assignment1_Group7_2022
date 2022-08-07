package za.ac.cput.repository.contactType;
/* ContactTypeRepository.java
 This is a Contact Type Repository
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import za.ac.cput.domain.contact.ContactType;


import java.util.HashSet;
import java.util.Set;

public class ContactTypeRepository implements IContactTypeRepository {
    public static ContactTypeRepository repository = null;
    public Set<ContactType> contactTypeDB = null;

    private ContactTypeRepository(){
        contactTypeDB = new HashSet<ContactType>();
    }
    public static ContactTypeRepository getRepository(){
        if(repository == null){
            repository = new ContactTypeRepository();
        }
        return repository;
    }

    @Override
    public ContactType create(ContactType contactType) {
        return null;
    }

    @Override
    public ContactType read(String Id) {
        for(ContactType c : contactTypeDB)
            if(c.getId().equals(Id)) {
                return c;
            }
        return null;
    }

    @Override
    public ContactType update(ContactType contactType) {
        ContactType oldContactType = read(contactType.getId());
        if(oldContactType != null){
            contactTypeDB.remove(oldContactType);
            contactTypeDB.add(contactType);
            return contactType;
        }
        return null;
    }

    @Override
    public boolean delete(String Id) {
        ContactType contactTypeDeleted = read(Id);
        if(contactTypeDB == null)
            return false;
        contactTypeDB.remove(contactTypeDeleted);
        return true;
    }

    @Override
    public Set<ContactType> getAll() {
        return contactTypeDB;
    }
}
