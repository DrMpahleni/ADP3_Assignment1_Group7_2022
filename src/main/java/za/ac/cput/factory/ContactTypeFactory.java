package za.ac.cput.factory;

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
