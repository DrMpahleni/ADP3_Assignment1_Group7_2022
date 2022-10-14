
package za.ac.cput.service.contactType.Impl;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.repository.contactType.IContactTypeRepository;
import za.ac.cput.service.contactType.IContactTypeService;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactTypeServiceImpl implements IContactTypeService {
    private IContactTypeRepository contactTypeRepository;

    public ContactTypeServiceImpl(IContactTypeRepository contactTypeRepository) {
        this.contactTypeRepository = contactTypeRepository;
    }

    public ContactTypeServiceImpl(){
    }

    @Override
    public ContactType create(ContactType contactType) {
        return contactTypeRepository.save(contactType);
    }
    @Override
    public Optional<ContactType> read(String Id) {
        return contactTypeRepository.findById(Id);
    }
    @Override
    public ContactType update(ContactType contactType) {
        return contactTypeRepository.save(contactType);
    }

    @Override
    public void delete(ContactType contactType) {
     contactTypeRepository.delete(contactType);
    }

    @Override
    public Set<ContactType> getAll() {
        return contactTypeRepository.getAll();
    }

    @Override
    public void deleteById(String Id) {
        Optional<ContactType> contactType = read(Id);
        if (contactType.isPresent()) delete(contactType.get());
    }
}
