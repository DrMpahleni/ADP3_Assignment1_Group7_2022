package za.ac.cput.repository.lookup.impl;

/* IIngredientsRepository.java
   This is a Ingredients Repository interface
   @Author: Lihle Njobe(21819388)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.lookup.Ingredients;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IIngredientsRepository extends IRepository<Ingredients, String> {
    public Set<Ingredients> getAll();
}