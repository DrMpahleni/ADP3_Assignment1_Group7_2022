package za.ac.cput.factory;

import za.ac.cput.entity.EmployeeContact;
import za.ac.cput.util.genericHelper;

public class EmployeeContactFactory {
    public static EmployeeContact createEmployeeContact(int employeeId, int contactTypeId, String contact){

        String employeeID = genericHelper.generateId();
        EmployeeContact employeeContact = new EmployeeContact.Builder().setEmployeeID(employeeID)
                .setContactTypeId(contactTypeId)
                .setContact(contact)
                .build();
        return employeeContact;

    }
}
