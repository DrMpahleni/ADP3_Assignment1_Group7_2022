package za.ac.cput.factory;

import za.ac.cput.entity.EmployeeGender;
import za.ac.cput.util.genericHelper;

public class EmployeeGenderFactory {
    public static EmployeeGender createEmployeeGender(String employeeId, String genderId){
        String employeeID = genericHelper.generateId();
        EmployeeGender employeeGender = new EmployeeGender.Builder().setEmployeeId(employeeId)
                .setGenderId(genderId)
                .build();
        return employeeGender;
    }
}
