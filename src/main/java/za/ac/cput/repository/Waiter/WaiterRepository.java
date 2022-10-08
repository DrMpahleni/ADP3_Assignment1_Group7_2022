/*
    Chef.java
    IRepository for Waiter
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 10 April 2022
 */

package za.ac.cput.repository.Waiter;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.role.Waiter;

public interface WaiterRepository extends JpaRepository<Waiter, Integer> {
}