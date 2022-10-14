package za.ac.cput.repository.contactType;
/* IEmployeeContactRepository.java
 This is a IEmployee Contact Repository Interface
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.contact.ContactType;
import java.util.Set;

@Repository
public interface IContactTypeRepository extends JpaRepository<ContactType, String> {
    public Set<ContactType> getAll();
}
