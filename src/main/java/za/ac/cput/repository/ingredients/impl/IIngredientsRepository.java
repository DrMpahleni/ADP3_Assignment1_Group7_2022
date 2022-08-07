package za.ac.cput.repository.ingredients.impl;

/* IIngredientsRepository.java
   This is a Ingredients Repository interface
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.repository.IRepository;

import java.util.Set;


public interface IIngredientsRepository extends IRepository<Ingredients, String> {
        public Set<Ingredients> getAll();
}
