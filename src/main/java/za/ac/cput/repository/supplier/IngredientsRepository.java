package za.ac.cput.repository.supplier;

/* IIngredientsRepository.java
   This is a Ingredients Repository interface
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.supplier.Ingredients;

import java.util.Set;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, String> {
    public Set<Ingredients> getAll();

}
