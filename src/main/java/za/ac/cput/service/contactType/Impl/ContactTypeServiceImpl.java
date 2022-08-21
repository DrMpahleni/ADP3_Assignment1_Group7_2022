package za.ac.cput.service.contactType.Impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.repository.contactType.ContactTypeRepository;
import za.ac.cput.service.contactType.IContactTypeService;

import java.util.Optional;
import java.util.Set;

@Service
public class ContactTypeServiceImpl implements IContactTypeService {
    private static ContactTypeServiceImpl contactTypeService = null;
    private ContactTypeRepository contactTypeRepository;
    public ContactTypeServiceImpl(){
        this.contactTypeRepository = ContactTypeRepository.getRepository();
    }

    public static ContactTypeServiceImpl getContactTypeService(){
        if(contactTypeService == null){
            contactTypeService = new ContactTypeServiceImpl();
        }
        return contactTypeService;
    }

    @Override
    public ContactType create(ContactType contactType) {
        return this.contactTypeRepository.create(contactType);
    }

    @Override
    public Optional<ContactType> read(String Id) {
        return Optional.ofNullable(this.contactTypeRepository.read(Id));
    }

    @Override
    public ContactType update(ContactType contactType) {
        return this.contactTypeRepository.update(contactType);
    }

    @Override
    public void delete(ContactType contactType) {
    return;
    }

    @Override
    public Set<ContactType> getAll() {
        return this.contactTypeRepository.getAll();
    }

    @Override
    public void deleteById(String Id) {
        Optional<ContactType> contactType = read(Id);
        if (contactType.isPresent()) delete(contactType.get());
    }
}
