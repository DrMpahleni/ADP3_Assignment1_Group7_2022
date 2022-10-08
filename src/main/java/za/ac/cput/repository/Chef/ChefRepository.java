/*
    Chef.java
    IRepository for Chef
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */

package za.ac.cput.repository.Chef;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.role.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer> {
}

