package za.ac.cput.service.restaurant;

/* OrderService.java
   This is Order service interface
   @Author: Lihle Njobe(218193882)
   Due date: 07 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.repository.restaurant.OrderRepository;


import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    private static OrderService service = null;

    @Autowired
    private OrderRepository repository;

    @Override
    public Order create(Order order) {

        return this.repository.save(order);
    }

    @Override
    public Optional<Order> read(Integer orderId) {
        return Optional.ofNullable(this.repository.findById(orderId).orElse(null));
    }

    @Override
    public Order update(Order order) {
        if (this.repository.existsById(order.getOrderId()))
            return this.repository.save(order);
        return null;
    }

    @Override
    public void delete(Order order) {
        this.repository.delete(order);

    }

    @Override
    public Set<Order> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Order getOrderGiven(String orderItem) {
        Order o = null;
        Set<Order> orders = getAll();
        for (Order order : orders) {
            if (order.getOrderItem().equals(orderItem)) {
                o = order;
                break;
            }
        }
        return o;
    }
}

