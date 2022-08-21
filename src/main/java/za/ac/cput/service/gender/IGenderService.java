package za.ac.cput.service.gender;

import za.ac.cput.domain.gender.Gender;
import za.ac.cput.service.IService;

import java.util.Set;

/* GenderService.java
 This is a Gender Service Interface
 Author: Vuyisa Nkangana(218192215)
 Due Date: 7 August 2022
  */
public interface IGenderService extends IService<Gender, String> {
    Set<Gender> getAll();
    void deleteById(String employeeId);
}
