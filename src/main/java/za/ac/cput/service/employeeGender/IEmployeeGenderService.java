package za.ac.cput.service.employeeGender;

/* EmployeeGenderService.java
 This is a Employee Gender Service Interface
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */

import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IEmployeeGenderService extends IService<EmployeeGender, String> {
    Set<EmployeeGender> getAll();
    void deleteById(String employeeId);
}
