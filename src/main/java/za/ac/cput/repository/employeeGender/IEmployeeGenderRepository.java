package za.ac.cput.repository.employeeGender;
/* IEmployeeGenderRepository.java
        This is a IEmployee Gender Repository Interface
        Author: Vuyisa Nkangana(218192215)
        Due Date: 10 April 2022
        */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.gender.EmployeeGender;
import java.util.Set;
@Repository
public interface IEmployeeGenderRepository extends JpaRepository<EmployeeGender, String> {
    public Set<EmployeeGender> getAll();
}
