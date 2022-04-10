package za.ac.cput.factory;

import za.ac.cput.entity.Manager;
import za.ac.cput.util.genericHelper;

public class ManagerFactory {

    public static Manager createManager(int managerID,int positionID,  String firstName, String lastName,String phoneNo, String emailAddress) {

        String employeeID = genericHelper.generateId();
        Manager manager= new Manager.Builder()
                .setManagerID(managerID)
                .setPositionID(positionID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNo(phoneNo)
                .setEmailAddress(emailAddress)
                .build();

        return manager;
    }
}
