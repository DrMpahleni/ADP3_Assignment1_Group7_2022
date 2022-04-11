package za.ac.cput.factory;
/* ContactTypeFactoryTest.java
 This is a Contact Type Factory Test Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactType;



import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ContactTypeFactoryTest {

    private ContactType contactT1;
    private ContactType contactT2;
    private ContactType contactT3;

    @BeforeEach
    void setUp() {
       ContactType contactT1 = new ContactType.Builder().setId("2003N").build();
       ContactType contact2 = contactT1;
    }

    @Test
    public void test() {

        ContactType contactType = ContactTypeFactory.createContactType("2002V", "Patric");
        System.out.println(contactType.toString());
        assertNotNull(contactType);
    }

    @Test
    public void testIdentity(){

        assertSame(contactT1, contactT2);
        System.out.println("Both Contact Type are identical");
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMinutes(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test Timed out");
        });
    }

    @Test
    @Disabled
    void testDisable() {

        assertEquals(contactT1, contactT2
        );
    }

}