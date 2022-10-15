package za.ac.cput.repository.employeeContact;
/* IEmployeeContactRepository.java
        This is a IEmployee Contact Repository Interface
        Author: Vuyisa Nkangana(218192215)
        Due Date: 10 April 2022
        */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.contact.EmployeeContact;
import java.util.Set;

@Repository
public interface IEmployeeContactRepository extends JpaRepository<EmployeeContact, String> {
    public Set<EmployeeContact> getAll();
}
