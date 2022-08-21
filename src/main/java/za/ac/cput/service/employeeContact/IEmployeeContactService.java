package za.ac.cput.service.employeeContact;

import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.service.IService;

import java.util.Set;

/* EmployeeContactService.java
 This is a Employee Contact Service Interface
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */
public interface IEmployeeContactService extends IService<EmployeeContact, String> {
    Set<EmployeeContact> getAll();
    void deleteById(String employeeId);
}
