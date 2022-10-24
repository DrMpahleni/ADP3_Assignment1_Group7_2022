package za.ac.cput.factory.contact;

/* EmployeeContactFactory.java
 This is a Employee Contact Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.util.genericHelper;

public class ContactTypeFactory {
    public static ContactType createContactType(String Id, String name) {
        String ID = genericHelper.generateId();
        ContactType contactType = new ContactType.Builder()
                .setId(Id)
                .setName(name)
                .build();
        return contactType;
    }
}
    /*public static EmployeeContact build(String id, String name){
        if(id.isEmpty() || id == null)
            throw new IllegalArgumentException("Enter Id");
        if(name.isEmpty() || name == null)
            throw new IllegalArgumentException(" Enter name");
        return new ContactType.Builder().id(id)
                .name(name)
                .build();
    }
}
*/