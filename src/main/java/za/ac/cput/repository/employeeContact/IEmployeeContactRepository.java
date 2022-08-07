package za.ac.cput.repository.employeeContact;
/* IEmployeeContactRepository.java
        This is a IEmployee Contact Repository Interface
        Author: Vuyisa Nkangana(218192215)
        Due Date: 10 April 2022
        */

import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeContactRepository extends IRepository<EmployeeContact, String> {
    public Set<EmployeeContact> getAll();
}
