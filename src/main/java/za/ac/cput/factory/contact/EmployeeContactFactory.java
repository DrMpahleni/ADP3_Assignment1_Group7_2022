package za.ac.cput.factory.contact;
/* EmployeeContact.java
 This is an Employee Contact Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */

import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.util.genericHelper;

public class EmployeeContactFactory {
    public static EmployeeContact createEmployeeContact(int employeeId, String contactTypeId, String contact){

        String employeeID = genericHelper.generateId();
    EmployeeContact employeeContact = new EmployeeContact.Builder().setEmployeeID(employeeID)
            .setContactTypeId(contactTypeId)
            .setContact(contact)
            .build();
    return employeeContact;

}
}

