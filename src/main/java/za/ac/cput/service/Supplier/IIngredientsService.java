package za.ac.cput.service.Supplier;
/* IIngredientsService.java
   This is IIngredients service class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;

public interface IIngredientsService extends IService<Ingredients, String> {
    List<Ingredients> getAll(String ingredientName);
    void deleteById(String ingredientName);


}