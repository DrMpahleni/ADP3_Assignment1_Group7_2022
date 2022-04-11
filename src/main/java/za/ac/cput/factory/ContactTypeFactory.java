package za.ac.cput.factory;

/* EmployeeContactFactory.java
 This is a Employee Contact Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import za.ac.cput.entity.ContactType;
import za.ac.cput.util.genericHelper;

public class ContactTypeFactory {
    public static ContactType createContactType(String Id, String name){
        String ID = genericHelper.generateId();
        ContactType contactType = new ContactType.Builder().setId(Id)
                .setName(name)
                .build();
        return contactType;
    }
}
