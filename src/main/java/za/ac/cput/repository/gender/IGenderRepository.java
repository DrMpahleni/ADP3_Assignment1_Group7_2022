package za.ac.cput.repository.gender;
/* IGenderRepository.java
        This is a IGender Repository Interface
        Author: Vuyisa Nkangana(218192215)
        Due Date: 10 April 2022
        */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.gender.Gender;
import java.util.Set;

@Repository
public interface IGenderRepository extends JpaRepository<Gender, String> {
    public Set<Gender>getAll();

}
