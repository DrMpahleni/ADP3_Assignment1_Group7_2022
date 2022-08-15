package za.ac.cput.service.restaurant;

/* IOrderService.java
   This is Order service interface
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Set;

public interface IOrderService extends IService<Order, Integer> {
    public Set<Order> getAll();
    public Order getOrderGiven(String orderItem);
    List<Order> getAll(Integer orderId);
}