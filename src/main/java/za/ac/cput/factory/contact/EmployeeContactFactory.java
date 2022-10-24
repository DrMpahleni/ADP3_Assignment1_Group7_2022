package za.ac.cput.factory.contact;
/* EmployeeContact.java
 This is an Employee Contact Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import org.hibernate.internal.util.StringHelper;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.util.genericHelper;

public class EmployeeContactFactory {
    public static EmployeeContact createEmployeeContact(String employeeId, String contactTypeId, String contact){
        String contactTypeID = genericHelper.generateId();
        EmployeeContact employeeContact = new EmployeeContact.Builder()
                .setContactTypeId(contactTypeId)
                .setEmployeeID(employeeId)
                .setContact(contact)
                .build();
        return employeeContact;

}


}

