package za.ac.cput.factory;
/* EmployeeGenderFactory.java
 This is a Employee Gender Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
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
