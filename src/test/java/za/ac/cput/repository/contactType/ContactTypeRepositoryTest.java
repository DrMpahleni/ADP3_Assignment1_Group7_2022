package za.ac.cput.repository.contactType;

/* ContactTypeRepositoryTest.java
 This is a Contact Type Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ContactTypeRepositoryTest {

    private final ContactType contactType1 = new ContactType.Builder()
            .setName("Vuyisa")
            .setId("Vuy9401")
            .build();

    @Autowired
    private IContactTypeRepository contactTypeRepository;
    private static ContactType contactType = ContactTypeFactory.createContactType("Siv7432", "Sivuyile");

    @Test
    void create() {
       ContactType created = contactTypeRepository.save(contactType1);
        assertEquals(contactType.getId(), created.getName());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        ContactType read = contactTypeRepository.getById(contactType1.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        ContactType updated = new ContactType.Builder().copy(contactType1).setName("Vuyisa").build();
        assertNotNull(contactTypeRepository.save(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        ContactType saved = contactTypeRepository.save(contactType1);
        List<ContactType> getAll = contactTypeRepository.findAll();
        contactTypeRepository.delete(saved);
        assertEquals(0, getAll.size());

    }
    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(contactTypeRepository.getAll());
    }

}