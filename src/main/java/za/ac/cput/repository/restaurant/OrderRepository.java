package za.ac.cput.repository.restaurant;

/* IOrderRepository.java
   This is an Order repository interface
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.domain.restaurant.Order;

import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    boolean delete(int orderId);
    public Set<Order> getAll();
}

