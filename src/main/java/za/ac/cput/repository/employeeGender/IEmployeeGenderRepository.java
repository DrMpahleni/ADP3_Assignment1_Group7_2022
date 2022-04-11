package za.ac.cput.repository.employeeGender;
/* IEmployeeGenderRepository.java
        This is a IEmployee Gender Repository Interface
        Author: Vuyisa Nkangana(218192215)
        Due Date: 10 April 2022
        */
import za.ac.cput.entity.EmployeeGender;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeGenderRepository extends IRepository <EmployeeGender, String> {
    public Set<EmployeeGender> getAll();
}
