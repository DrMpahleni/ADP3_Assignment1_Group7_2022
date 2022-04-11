package za.ac.cput.repository.contactType;

/* ContactTypeRepositoryTest.java
 This is a Contact Type Repository Test
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactType;
import za.ac.cput.factory.ContactTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

class ContactTypeRepositoryTest {
    private static ContactTypeRepository repository = ContactTypeRepository.getRepository();
    private static ContactType contactType = ContactTypeFactory.createContactType("Mavo001", "Ottor2001");

    @Test
    void create() {
       ContactType created = repository.create(contactType);
        assertEquals(contactType.getId(), created.getName());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        ContactType read = repository.read(contactType.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        ContactType updated = new ContactType.Builder().copy(contactType).setName("Vuyisa").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(contactType.getId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }

}