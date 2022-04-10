/*
    Chef.java
    IRepository for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */

package za.ac.cput.repository;


import za.ac.cput.entity.Chef;

import java.util.Set;

public interface IChefRepository extends IRepository <Chef, String> {

    Chef delete(int chefId);

    public Set<Chef> getAll();

    Chef read(int chefId);

    Chef update(int chefId);
}
