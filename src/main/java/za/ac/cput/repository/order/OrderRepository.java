package za.ac.cput.repository.order;

/* OrderRepository.java
   This is a Order Repository class
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.repository.order.impl.IOrderRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderRepository implements IOrderRepository {

    private static OrderRepository repository = null;
    private Set<Order> orderDB = null;

    private OrderRepository() {
        orderDB = new HashSet<>();
    }
    public static OrderRepository getRepository() {
        if (repository == null) {
            repository = new OrderRepository();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        boolean success = orderDB.add(order);
        if(!success)
            return null;
        return order;
    }

    @Override
    public Order read(Integer orderId) {
        Order order = orderDB.stream()
                .filter(o -> o.getOrderId()== orderId)
                .findAny()
                .orElse(null);
        return order;
    }

    @Override
    public Order update(Order order) {
        Order oldOrder = read(order.getOrderId());
        if (oldOrder != null) {
            orderDB.remove(oldOrder);
            orderDB.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(Integer orderId) {
        Order orderToDelete = read(orderId);
        if (orderToDelete == null)
            return false;
        orderDB.remove(orderToDelete);
        return true;
    }

    @Override
    public Set<Order> getAll() {
        return orderDB;
    }
}


