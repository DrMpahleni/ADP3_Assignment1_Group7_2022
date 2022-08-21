package za.ac.cput.service.contactType.Impl;

/* ContactTypeServiceTest.java
  This is a Contact Type Service Test
  Author: Vuyisa Nkangana(218192215)
  Due Date: August 2022
  */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

public class ContactTypeServiceImplTest {

private static ContactType contactType = ContactTypeFactory.createContactType("VUY20220101","Mavo");

    @Autowired
    private ContactTypeServiceImpl contactTypeService;

@Test
    void create(){
    ContactType created = contactTypeService.create(contactType);
    assertEquals(created.getId(), contactType.getName());
    System.out.println("created" + created);
}
@Test
   @Disabled
   void read(){
    Optional<ContactType> read = contactTypeService.read(contactType.getId());
    assertNotNull(read);
    System.out.println("read" + read);
}
@Test
   @Disabled
   void update(){
    ContactType saved = contactTypeService.create(contactType);
    ContactType updated = new ContactType.Builder().copy(contactType).setId("Lom021").build();
    assertNotNull(updated);
    System.out.println(updated);
}
@Test
    @Disabled
    void delete(){
    this.contactTypeService.delete(contactType);
}
@Test
    void getAll(){
    System.out.println("Showing All");
    System.out.println(contactTypeService.getAll());
}
}